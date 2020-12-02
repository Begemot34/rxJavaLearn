package pw.kozhanov.rxjava.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel
import pw.kozhanov.rxjava.R
import pw.kozhanov.rxjava.databinding.CountriesListFragmentBinding
import pw.kozhanov.rxjava.utils.viewLifecycle

class CountriesListFragment : Fragment() {

    var binding: CountriesListFragmentBinding by viewLifecycle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CountriesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel: CountriesListViewModel by viewModel()
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.error.observe(
            viewLifecycleOwner,
            { error -> Snackbar.make(binding.root, error, Snackbar.LENGTH_LONG).show() })

        val adapter = CountriesAdapter()
        binding.rvCountries.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCountries.adapter = adapter
        viewModel.countries.observe(viewLifecycleOwner, { adapter.updateList(it) })
    }

}