package petopia_todo_ult.dto;

import java.util.UUID;

public class LoginResponseDTO {
    String status;
    UUID token;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
