@Entity
@Table(name = "session")
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Column(name = "session_date")
    private LocalDate sessionDate;

    // constructors if needed
}
