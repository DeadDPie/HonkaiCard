package com.example.honkaicard
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.widget.Button

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MyBottomSheetDialogFragment : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button4: Button = view.findViewById(R.id.filterRare4)

        button4.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity2::class.java)

            intent.putExtra("Filter", '4')

            startActivity(intent)
        }
        val button5: Button = view.findViewById(R.id.filterRare5)

        button5.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity2::class.java)

            intent.putExtra("Filter", '5')

            startActivity(intent)
        }
        val buttonP: Button = view.findViewById(R.id.filterPath)

        buttonP.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity2::class.java)

            intent.putExtra("Filter", 'P')

            startActivity(intent)
        }
    }
}
