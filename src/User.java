public class User {
    private int rank = -8;
    private int progress = 0;

    public int getRank() { return rank; }
    public int getProgress() { return progress; }

    public String toString() { return "User{rank=" + rank + ", progress=" + progress + "}"; }
    public void incProgress(int activity) {
        if (activity == 0 || activity < -8 || activity > 8) throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        if (activity == rank) progress+=3;
        else if (activity < rank) progress++;
        else {
            if ((activity > -1 && rank <= 1) || (activity >= 1 && rank < -1)) {
                progress += 10*((activity-rank-1)*(activity-rank-1));
            }
            else { progress += 10*((activity-rank)*(activity-rank)); }
        }

        if (progress >= 100) {
            do {
                if (rank == -1) { rank = 1; }
                else { rank++; }
                progress -= 100;
            } while (progress > 100);
        }
    }
}
