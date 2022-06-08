package com.sheikh.telegram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessagesViewHolder> {

    private List<Message> messages;

    public MessageAdapter() {
        messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_message , parent , false);
        return new MessagesViewHolder(result);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.textViewMessageAuthor.setText(message.getauthor());
        String urlToImage = message.getImageUrl();
        String messageAuthor = message.getauthor();
        if (urlToImage != null && !urlToImage.isEmpty()) {
            holder.imageViewImage.setVisibility(View.VISIBLE);
        }
        if (messageAuthor != null && !messageAuthor.isEmpty()) {
            holder.textViewMessage.setText(message.getmessage());
            holder.imageViewImage.setVisibility(View.GONE);
            Picasso.get().load(urlToImage).into(holder.imageViewImage);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessagesViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewMessageAuthor;
        private TextView textViewMessage;
        private ImageView imageViewImage;

        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);
            textViewMessageAuthor = itemView.findViewById(R.id.textViewAuthor);
            imageViewImage = itemView.findViewById(R.id.imageViewImage);
        }
    }
}
