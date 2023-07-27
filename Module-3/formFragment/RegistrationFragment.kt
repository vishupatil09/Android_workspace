import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.formregester.R

class RegistrationFragment : Fragment() {

    private lateinit var btnRegister: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        // Initialize the button
        btnRegister = view.findViewById(R.id.btnRegister)

        // Set click listener for the button
        btnRegister.setOnClickListener {
            // Handle registration button click here
            // For example, validate user input and perform registration logic
        }

        return view
    }
}
