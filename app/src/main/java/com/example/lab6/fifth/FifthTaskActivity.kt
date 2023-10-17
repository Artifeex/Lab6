package com.example.lab6.fifth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.R
import com.example.lab6.databinding.ActivityFifthTaskBinding
import com.example.lab6.databinding.ActivityThirdTaskBinding
import com.example.lab6.second.ElementsAdapter
import com.example.lab6.third.ThirdTaskActivity

class FifthTaskActivity : AppCompatActivity(), TaskTextDialog.DialogListener {

    private val binding by lazy {
        ActivityFifthTaskBinding.inflate(layoutInflater)
    }

    override fun onDialogPositiveClick(text: String) {
        viewModel.addTask(text)
    }

    private lateinit var viewModel: FifthTaskViewModel
    private lateinit var adapter: ElementsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(FifthTaskViewModel::class.java)
        viewModel = ViewModelProvider(this)[FifthTaskViewModel::class.java]
        adapter = ElementsAdapter()
        binding.rvTvs.adapter = adapter
        observeViewModel()
        binding.fabAddTv.setOnClickListener {
            TaskTextDialog().show(supportFragmentManager, null)
        }
        setupSwipeListener()
    }

    private fun setupSwipeListener() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteTask(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rvTvs)
    }

    private fun observeViewModel() {
        viewModel.getTasks().observe(this) {
            adapter.submitList(it)
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, FifthTaskActivity::class.java)
    }
}