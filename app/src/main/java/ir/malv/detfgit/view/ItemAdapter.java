package ir.malv.detfgit.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import ir.malv.detfgit.R;
import ir.malv.detfgit.network.model.Item;

public class ItemAdapter  extends ArrayAdapter {
    List<Item> items;
    Context context;

    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        items =objects;
        this.context =context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       Item item =items.get(position);
        ViewHolder viewHolder;
           LayoutInflater layoutInflater =
                   (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = layoutInflater.inflate(R.layout.item_of_listview,parent,false);
           viewHolder= new ViewHolder(convertView);
           convertView.setTag(viewHolder);
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
        public void fill(final Item item){
            // set information from item
            title.setText(item.getTitle());
            description.setText(item.getDescription());
            link.setText("go to page");
            author.setText(item.getAuthor());
            enclosureIV.setImageBitmap(image2Bitmap(R.drawable.image));
            //get image from net
            getImageFromUrl(enclosureIV,item.getEnclosure().getUrl());
           // getImageFromNetAndSetToImageView(item);

            //set listener on link to go to page in website
            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                    context.startActivity(myIntent);
                }
            });
        }




    private Bitmap image2Bitmap(@DrawableRes int  id){


        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        bitmap = Bitmap.createScaledBitmap(bitmap,100
                ,100,true);

        return bitmap;


    }

    void getImageFromUrl(ImageView imageView,String url){
        new DownloadImageTask(imageView)
                .execute(url);
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {

            result = Bitmap.createScaledBitmap(result,100
                    ,100,true);

            bmImage.setImageBitmap(result);
        }
    }
        }
}
