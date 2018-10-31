package ir.malv.detfgit.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import ir.malv.detfgit.R;
import ir.malv.detfgit.network.model.Item;

public class ItemAdapter  extends ArrayAdapter {
    Item [] items;
    Context context;


    public ItemAdapter(Context context, int resource, Item [] items) {
        super(context, resource, items);
        this.context = context;
        this.items =items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       Item item = items[position];
        ViewHolder viewHolder;
       if(convertView==null){
           LayoutInflater layoutInflater =
                   (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = layoutInflater.inflate(R.layout.item_of_listview,parent,false);
           viewHolder= new ViewHolder(convertView);
           convertView.setTag(viewHolder);


       }else {
           viewHolder = (ViewHolder) convertView.getTag();
       }
       viewHolder.fill(item);
       return convertView;
    }
        //ViewHolder for hold view :)
    public class ViewHolder{
        private TextView title;
        private TextView description;
        private TextView link;
        private TextView author;
        private ImageView enclosureIV;
        public ViewHolder(View convertView) {
            initView(convertView);


        }

        private void initView(View convertView) {

            title = convertView.findViewById(R.id.titleOfNews);
            description =convertView.findViewById(R.id.description);
            link = convertView.findViewById(R.id.linkOfItem);
            author  =convertView.findViewById(R.id.author);
            enclosureIV = convertView.findViewById(R.id.enclosure);





        }
        public void fill(Item item){
            // set information from item
            title.setText(item.getTitle());
            description.setText(item.getDescription());
            link.setText("go to page");
            author.setText(item.getAuthor());
            enclosureIV.setImageBitmap(image2Bitmap(R.drawable.image));
            //get image from net
            getImageFromNetAndSetToImageView(item);

            //set listener on link to go to page in website
            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link.getText().toString()));
                    context.startActivity(myIntent);
                }
            });
        }

            private void getImageFromNetAndSetToImageView(Item item) {
                try {
                    //get image from net
                    URL url = new URL(item.getEnclosure().getUrl());
                    Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    //ScaledBitmap
                    image = Bitmap.createScaledBitmap(image,100
                            ,100,true);
                    //set in image view
                    enclosureIV.setImageBitmap(image);
                } catch(IOException e) {
                    System.out.println(e);
                }
            }
        }

    private Bitmap image2Bitmap(@DrawableRes int  id){


        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        bitmap = Bitmap.createScaledBitmap(bitmap,100
                ,100,true);

        Bitmap bitmap2;
        byte[] BYTE;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();



        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
        BYTE = bytearrayoutputstream.toByteArray();

        bitmap2 = BitmapFactory.decodeByteArray(BYTE,0,BYTE.length);
        return bitmap2;


    }
}
