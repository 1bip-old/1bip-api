package api.bip.flows;
import br.com.efi.Auth.Auth;
public class AuthService {
    public String getTokenEfi() throws Exception {
        return Auth.getToken();
    }
}
