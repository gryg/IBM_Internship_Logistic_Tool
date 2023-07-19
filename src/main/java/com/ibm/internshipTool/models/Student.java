@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "is_leader")
    private boolean isLeader;

    @Column(name = "join_date")
    private LocalDate joinDate;

    // constructors, getters, and setters
}
