public class User {
    private Name name;
    private NickName nickName;
    private Mail mail;
    private Password password;
    private ConfirmationPassword confirmationPassword;
    private DateOfBirth dateOfBirth;
    private Gender gender;

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