public class Cadetes {

    private String name;
    private String pitch;

    public void setNamePitch(String name, String pitch) {
        this.name = name;
        this.pitch = pitch;
    }

    public void startPitch(){
        System.out.println("Ola, sou " + name + " e " + pitch);
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }


}
