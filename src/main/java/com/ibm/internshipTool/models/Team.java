@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    private Student leader;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    // constructors, getters, and setters
}
