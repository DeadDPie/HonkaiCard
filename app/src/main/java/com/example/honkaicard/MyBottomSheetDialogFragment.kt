package com.example.honkaicard
import android.content.Context
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

    private var listener: OnButtonClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnButtonClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement BottomSheetListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val button4: Button = view.findViewById(R.id.filterRare4)
        button4.setOnClickListener {
            listener?.onButtonFourClicked("4")
            dismiss()
        }
        val button5: Button = view.findViewById(R.id.filterRare5)

        button5.setOnClickListener {
            listener?.onButtonFourClicked("5")
            dismiss()
        }

        val buttonall: Button = view.findViewById(R.id.filterALL)

        buttonall.setOnClickListener {
            listener?.onButtonFourClicked("all")
            dismiss()
        }
        val buttonfav: Button = view.findViewById(R.id.filterFav)

        buttonfav.setOnClickListener {
            listener?.onButtonFourClicked("liked")
            dismiss()
        }
        val lightningDamage: Button = view.findViewById(R.id.lightningDamage)

        lightningDamage.setOnClickListener {
            listener?.onButtonFourClicked("lightningDamage")
            dismiss()
        }
        val fireDamage: Button = view.findViewById(R.id.fireDamage)

        fireDamage.setOnClickListener {
            listener?.onButtonFourClicked("fireDamage")
            dismiss()
        }
        val physicalDamage: Button = view.findViewById(R.id.physicalDamage)

        physicalDamage.setOnClickListener {
            listener?.onButtonFourClicked("physicalDamage")
            dismiss()
        }
        val iceDamage: Button = view.findViewById(R.id.iceDamage)

        iceDamage.setOnClickListener {
            listener?.onButtonFourClicked("iceDamage")
            dismiss()
        }
        val quantumDamage: Button = view.findViewById(R.id.quantumDamage)

        quantumDamage.setOnClickListener {
            listener?.onButtonFourClicked("quantumDamage")
            dismiss()
        }
        val imaginaryDamage: Button = view.findViewById(R.id.imaginaryDamage)

        imaginaryDamage.setOnClickListener {
            listener?.onButtonFourClicked("imaginaryDamage")
            dismiss()
        }
        val windDamage: Button = view.findViewById(R.id.windDamage)

        windDamage.setOnClickListener {
            listener?.onButtonFourClicked("windDamage")
            dismiss()
        }


/*
        button4.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity2::class.java)

            intent.putExtra("Filter", "4")

            //startActivity(intent)
            requireContext().startActivity(intent)
        }*/
        /*val button5: Button = view.findViewById(R.id.filterRare5)

        button5.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity2::class.java)

            intent.putExtra("Filter", "5")

            requireContext().startActivity(intent)
        }*/
        /*
        val buttonP: Button = view.findViewById(R.id.filterPath)

        buttonP.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity2::class.java)

            intent.putExtra("Filter", "P")

            requireContext().startActivity(intent)
        }*/
    }
}
/*<Button
        android:id="@+id/filterPath"
        android:layout_width="200dp"
        android:layout_gravity="center"
        android:layout_height="wrap_content"
        android:text="path" />
    <Button
        android:id="@+id/item_list_button"
        android:layout_width="200dp"
        android:layout_gravity="center"
        android:layout_height="wrap_content"
        android:text="Отфильтровать" />*/