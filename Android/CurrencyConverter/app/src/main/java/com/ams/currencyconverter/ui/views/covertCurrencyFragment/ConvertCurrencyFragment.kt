package com.ams.currencyconverter.ui.views.covertCurrencyFragment

import android.text.InputType
import android.view.View
import android.widget.TextView
import com.ams.androiddevkit.utils.extensions.tryCast
import com.ams.currencyconverter.R
import com.ams.currencyconverter.common.baseClasses.mvvm.AppFragment
import com.ams.currencyconverter.ui.views.fragmentHostActivity.SharedViewModel
import kotlinx.android.synthetic.main.fragment_convert_currency.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ConvertCurrencyFragment: AppFragment<ConvertCurrencyViewModel>(ConvertCurrencyViewModel::class), View.OnClickListener {

    private var typedCharsLength = 0
    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun getViewId() = R.layout.fragment_convert_currency

    override fun initUI() {
        sharedViewModel.getChosenCurrencyInfo().apply {
            chosen_currency_text_view.text = currencyName
            getViewModel()?.setChosenCurrencyInfo(currencyName!!, currencyRate)
        }
        // Disable soft keyboard input
        base_currency_edit_text.inputType = InputType.TYPE_NULL
        // Disable physical/hard keyboard input (Like external keyboard).
        // Ref: https://stackoverflow.com/a/36039125/6927433
        base_currency_edit_text.setOnKeyListener { _, _, _ -> true }
        t9_key_convert.setOnClickListener {
            getViewModel()?.convertCurrency(base_currency_edit_text.text.toString())
        }
        t9_key_clear.setOnClickListener {
            base_currency_edit_text.text = null
        }
        t9_key_backspace.setOnClickListener {
            base_currency_edit_text.text?.let {
                typedCharsLength = it.length
                if(typedCharsLength > 0) {
                    it.delete(typedCharsLength - 1, typedCharsLength)
                }
            }
        }
        t9_key_0.setOnClickListener(this)
        t9_key_1.setOnClickListener(this)
        t9_key_2.setOnClickListener(this)
        t9_key_3.setOnClickListener(this)
        t9_key_4.setOnClickListener(this)
        t9_key_5.setOnClickListener(this)
        t9_key_6.setOnClickListener(this)
        t9_key_7.setOnClickListener(this)
        t9_key_8.setOnClickListener(this)
        t9_key_9.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view?.let {
            base_currency_edit_text.append((it as TextView).text)
        }
    }

    override fun onRenderStateWithResult(obj: Any?) {
        obj.tryCast<Float> {
            chosen_currency_edit_text.setText(this.toString())
        }
    }
}