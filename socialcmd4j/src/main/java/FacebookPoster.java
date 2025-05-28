import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

public class FacebookPoster {
    public static void main(String[] args) {
        // Instanciar la conexión a Facebook
        Facebook facebook = new FacebookFactory().getInstance();

        // Configura tu App ID y App Secret (los obtienes de developers.facebook.com)
        facebook.setOAuthAppId("1336817047421879 ", "190e400b16b49d62577f89648f5e2730 ");

        // Agrega el token de acceso (el que ya generaste)
        facebook.setOAuthAccessToken(
                new AccessToken("EAASZC0ZCk9w7cBO115EpjaEbnByziBLJ12lFTvr8LMNv69elDmsvfrAmBQZBwcoMDeBcFYpVczdmfrmQPCxkFk5yPDuyfXpAZAxlYvg8MIF58VIhVL8DcVktgxN9SpqIKbOIwKmZCIPuJ8XCVmyGuY95itvmCwrwacmTo3tNiMx4n8Vypea2BSqJFPP3gfVUjQwZDZD", null)
        );

        try {
            // Publica en tu perfil
            facebook.postStatusMessage("¡Hola desde Java con facebook4j!");
            System.out.println("✅ Publicación realizada correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al publicar:");
            e.printStackTrace();
        }
    }
}
