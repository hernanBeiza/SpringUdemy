package cl.hiperactivo.token.models;

public class UsuarioModel {
        private int idusuario;
        private String user;
        private String pass;

        public UsuarioModel() {
        }

        public UsuarioModel(int idusuario, String user, String pass) {
            this.idusuario = idusuario;
            this.user = user;
            this.pass = pass;
        }

        public int getIdusuario() {
            return idusuario;
        }

        public void setIdusuario(int idusuario) {
            this.idusuario = idusuario;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        @Override
        public String toString() {
            return "UsuarioModel{" +
                    "idusuario=" + idusuario +
                    ", user='" + user + '\'' +
                    ", pass='" + pass + '\'' +
                    '}';
        }
}