package gameLogic;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.BloomFilter;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.shadow.CompareMode;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.util.SkyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Environment extends BaseAppState {
    private final Spatial dataBaseStack;
    private AmbientLight ambientLight;
    private PointLight pointLight;
    private final DirectionalLight dl=new DirectionalLight();
    private final List<ColorRGBA> colorRGBASet= Arrays.asList(ColorRGBA.White,ColorRGBA.White.mult(1.5f),ColorRGBA.White.mult(2f),ColorRGBA.White.mult(ColorRGBA.Cyan),ColorRGBA.Cyan,ColorRGBA.Cyan.mult(1.5f),ColorRGBA.Gray.mult(2f));
    private final List<Vector3f> directionSet= new ArrayList<>();
    private final float COLORFIY_TIME=3.5f;
    private float timer=0.0f;
    private int dlColorIndex=0;
    private int dlDirectionIndex=0;
    public Environment(Spatial dataBaseStack) {
        this.dataBaseStack=dataBaseStack;
    }

    @Override
    protected void initialize(Application app) {
        directionSet.add(new Vector3f(2f,-5f,dataBaseStack.getLocalTranslation().getZ()));
        directionSet.add(new Vector3f(4f,-3f,dataBaseStack.getLocalTranslation().getZ()));
        directionSet.add(new Vector3f(6f,-3f,dataBaseStack.getLocalTranslation().getZ()));
        directionSet.add(new Vector3f(8f,-2f,dataBaseStack.getLocalTranslation().getZ()));
        directionSet.add(new Vector3f(8f,-1f,dataBaseStack.getLocalTranslation().getZ()));
        directionSet.add(new Vector3f(8f,0f,dataBaseStack.getLocalTranslation().getZ()));

        directionSet.add(new Vector3f(8f,5f,dataBaseStack.getLocalTranslation().getZ()));
        directionSet.add(new Vector3f(6f,3f,dataBaseStack.getLocalTranslation().getZ()));
        directionSet.add(new Vector3f(4f,3f,dataBaseStack.getLocalTranslation().getZ()));
        directionSet.add(new Vector3f(2f,5f,dataBaseStack.getLocalTranslation().getZ()));


        ambientLight=new AmbientLight();
        ambientLight.setColor(colorRGBASet.get(0));
        dataBaseStack.getParent().addLight(ambientLight);

        dl.setDirection(directionSet.get(0));
        dl.setColor(colorRGBASet.get(0));
        dataBaseStack.getParent().addLight(dl);

//        DirectionalLightShadowRenderer dlsr=new DirectionalLightShadowRenderer(app.getAssetManager(),512,2);
//        dlsr.setLight(dl);
//        dlsr.setShadowIntensity(0.2f);
//        dlsr.setLambda(0.55f);
//        dlsr.setShadowCompareMode(CompareMode.Hardware);
//        dlsr.setShadowZExtend(23f);
//        dlsr.setShadowZFadeLength(8f);
//        dataBaseStack.setShadowMode(RenderQueue.ShadowMode.Receive);
//        app.getViewPort().addProcessor(dlsr);

        pointLight=new PointLight();
        pointLight.setPosition(dataBaseStack.getLocalTranslation().add(new Vector3f(0,10f,0)));
        pointLight.setRadius(2000);
        dataBaseStack.getParent().addLight(pointLight);

//        BloomFilter bloomFilter=new BloomFilter();
//        FilterPostProcessor filterPostProcessor=new FilterPostProcessor(app.getAssetManager());
//        filterPostProcessor.addFilter(bloomFilter);
//        app.getViewPort().addProcessor(filterPostProcessor);

        Geometry sky = (Geometry) SkyFactory.createSky(app.getAssetManager(),
                app.getAssetManager().loadTexture("assets/Textures/sky.jpg"),Vector3f.UNIT_XYZ, SkyFactory.EnvMapType.EquirectMap);
        sky.setLocalScale(0.5f);
        sky.getMaterial().getAdditionalRenderState().setDepthFunc(RenderState.TestFunction.LessOrEqual);


        dataBaseStack.getParent().attachChild(sky);

    }

    @Override
    protected void cleanup(Application app) {

    }

    @Override
    protected void onEnable() {

    }

    @Override
    protected void onDisable() {

    }

    @Override
    public void update(float tpf) {
        //simple dynamic illumination(DI).
        timer += tpf;
        if ( timer >= COLORFIY_TIME ){
            if ( dlDirectionIndex < directionSet.size() - 1 ){
                dl.setDirection(dataBaseStack.getLocalTranslation().add(directionSet.get(++dlDirectionIndex).normalize()));
            } else {
                dlDirectionIndex = 0;
            }
            if ( dlColorIndex < colorRGBASet.size() - 1 ){
                dl.setColor(colorRGBASet.get(++dlColorIndex));
                pointLight.setColor(colorRGBASet.get(dlColorIndex));
            } else {
                dlColorIndex = 0;
            }
            timer = 0.0f;
        }
    }
}
