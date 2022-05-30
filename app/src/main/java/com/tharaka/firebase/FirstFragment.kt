package com.tharaka.firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.tharaka.firebase.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    var db = FirebaseFirestore.getInstance() ;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener{
            val firstName = binding.firstName.text.toString() ;
            val lastName = binding.lastName.text.toString()
            val user = mapOf("first" to firstName, "last" to lastName)
            db.collection("users").add(user);
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}