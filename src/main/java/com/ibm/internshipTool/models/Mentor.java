@Entity
@Table(name = "mentors")
@Data
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // constructors if needed
}
