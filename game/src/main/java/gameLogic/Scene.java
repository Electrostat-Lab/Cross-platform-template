package gameLogic;

import com.jme3.anim.AnimComposer;
import com.jme3.app.Application;
import com.jme3.app.LegacyApplication;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.input.ChaseCamera;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.texture.Texture;

public class Scene extends BaseAppState {

    private Spatial dataBaseStack;
    private static final float ENV_TIME = 0.5f;
    private float timer=0.0f;

    @Override
    protected void initialize(Application app) {
        dataBaseStack = app.getAssetManager().loadModel("assets/Models/Database.j3o");
        dataBaseStack.setLocalScale(0.6f);
        dataBaseStack.setName("DataBaseStackModel");

        Material material = new Material(app.getAssetManager(),"Common/MatDefs/Light/PBRLighting.j3md");
        /*metalness , max is 1*/
        material.setFloat("Metallic", 0.5f);
        /*Roughness , 1 is the max roughnesss*/
        material.setFloat("Roughness", 0.5f);
        material.setFloat("EmissivePower",1.0f);
        material.setFloat("EmissiveIntensity",2.0f);
        material.setBoolean("HorizonFade",true);
        material.setVector3("LightDir",new Vector3f(-0.5f,-0.5f,-0.5f).normalize());
        material.setBoolean("BackfaceShadows",true);
        /*Reflection color*/
        material.setColor("Specular", ColorRGBA.Cyan.mult(3.5f));
        Texture texture=app.getAssetManager().loadTexture("assets/Textures/dataBaseTexture.jpg");
        material.setTexture("BaseColorMap",texture);
        material.setReceivesShadows(true);
        dataBaseStack.setMaterial(material);

        app.getCamera().setFrustumNear(0.7f);
        ChaseCamera chaseCamera = new ChaseCamera(app.getCamera(), dataBaseStack, app.getInputManager());
        chaseCamera.setDragToRotate(true);
        chaseCamera.setSmoothMotion(true);
        chaseCamera.setDefaultDistance(-30f);
        chaseCamera.setMaxDistance(-10f);
        chaseCamera.setMinDistance(-5f);
        chaseCamera.setDefaultVerticalRotation(-FastMath.QUARTER_PI/2);
        chaseCamera.setDefaultHorizontalRotation(-FastMath.HALF_PI);
        chaseCamera.setHideCursorOnRotate(true);
        ((SimpleApplication)getApplication()).getRootNode().attachChild(dataBaseStack);

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
        //synchronized component addition to minimize scene tear
        timer+=tpf;
        if ( timer >= ENV_TIME ){
            if(!getStateManager().hasState(getStateManager().getState(Environment.class))){
                getApplication().getStateManager().attach(new Environment(dataBaseStack));
            }
            getApplication().getStateManager().detach(this);
        }
    }
}
