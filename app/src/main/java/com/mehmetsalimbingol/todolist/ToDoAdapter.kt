import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mehmetsalimbingol.todolist.Item
import com.mehmetsalimbingol.todolist.R

class ToDoAdapter(private val itemList: MutableList<Item>) : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox) // CheckBox'ı tanımla
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_to_do_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]


        holder.titleTextView.text = currentItem.title
        holder.descriptionTextView.text = currentItem.description

        // CheckBox'un durumunu ayarla
        holder.checkBox.isChecked = currentItem.isChecked

        // CheckBox durumu değiştiğinde item'a işaretleme durumunu yansıt
        holder.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            currentItem.isChecked = isChecked
        }


        holder.deleteButton.setOnClickListener {

            itemList.removeAt(position)

            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
