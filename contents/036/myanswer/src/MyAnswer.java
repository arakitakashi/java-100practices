// synchronizedブロック: 複数のスレッドが同時にリソースにアクセスしようとした際に
// そのリソースに対するアクセスを1つのスレッドに制限することができる。
public class MyAnswer {
    private List<Object> members;
    public void add(Object member) {
        synchronized (members) {
            members.add(member);
        }
    }
    public void replace(Object oldMember, Object newMember) {
        synchronized (members) {
            if (members.contains(oldMember)) {
                members.remove(oldMember);
                members.add(newMember);
            }
        }
    }
}
