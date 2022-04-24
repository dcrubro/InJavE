package com.dcrubro.InJavE2D.object.components;

import com.dcrubro.InJavE2D.object.Component;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class Rigidbody extends Component {

    private int colliderType = 0;
    private float friction = 0.8f;
    private Vector3f velocity = new Vector3f(0,0.5f,0);
    private transient Vector4f tmp = new Vector4f(0,0,0,0);

    @Override
    public void start() {

    }
}
