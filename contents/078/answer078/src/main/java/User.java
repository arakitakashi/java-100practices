public class User {
    private final Name name;
    private final NickName nickName;
    private final Mail mail;
    private final Password password;
    private final ConfirmationPassword confirmationPassword;
    private final DateOfBirth dateOfBirth;
    private final Gender gender;

    public User(Name name, NickName nickName, Mail mail, Password password,
                ConfirmationPassword confirmationPassword, DateOfBirth dateOfBirth, Gender gender) {
        this.name = name;
        this.nickName = nickName;
        this.mail = mail;
        this.password = password;
        this.confirmationPassword = confirmationPassword;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}