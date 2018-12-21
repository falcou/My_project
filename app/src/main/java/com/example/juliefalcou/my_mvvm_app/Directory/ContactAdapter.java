package com.example.juliefalcou.my_mvvm_app.Directory;

import android.support.v7.widget.RecyclerView;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juliefalcou.my_mvvm_app.R;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {


    private List<Contact> contacts = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new ContactHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        holder.textViewName.setText(contacts.get(position).getName());
        holder.textViewRole.setText(contacts.get(position).getRole());
        holder.textViewLetter.setText(String.valueOf(contacts.get(position).getFirst_letter()));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    Contact getContactAt(int position) {
        return contacts.get(position);
    }

    class ContactHolder extends RecyclerView.ViewHolder {
        private TextView textViewName, textViewRole,textViewLetter;

        ContactHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.Contactadaptater_name);
            textViewRole = itemView.findViewById(R.id.Contactadaptater_role);
            textViewLetter = itemView.findViewById(R.id.ContactAdaptater_letter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(contacts.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Contact contact);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
