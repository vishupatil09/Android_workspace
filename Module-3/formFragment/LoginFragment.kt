import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.formregester.R

class LoginFragment : Fragment() {

    private lateinit var btnLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Initialize the button
        btnLogin = view.findViewById(R.id.btnLogin)

        // Set click listener for the button
        btnLogin.setOnClickListener {
            // Handle login button click here
            // For example, validate user input and perform login logic
        }

        return view
    }
}
