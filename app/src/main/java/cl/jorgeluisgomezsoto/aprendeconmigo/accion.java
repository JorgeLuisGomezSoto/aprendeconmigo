package cl.jorgeluisgomezsoto.aprendeconmigo;

public class accion {
    public String tipoaccion;
    public String detalle;
    public String uid;

    public accion() {
    }

    public String getTipoaccion() {
        return tipoaccion;
    }

    public void setTipoaccion(String tipoaccion) {
        this.tipoaccion = tipoaccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return tipoaccion + '\n' + detalle;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
