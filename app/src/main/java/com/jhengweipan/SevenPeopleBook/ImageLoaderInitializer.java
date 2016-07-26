package com.jhengweipan.SevenPeopleBook;

import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by redjack on 15/7/14.
 */
public class ImageLoaderInitializer {

    public static ImageLoader Instance(Context context){

        /**
         * 參考
         * http://blog.csdn.net/vipzjyno1/article/details/23206387
         */

        File cacheDir = StorageUtils.getCacheDirectory(context);

        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showStubImage(R.drawable.load_default)
                        //.showStubImage(R.drawable.ic_launcher)
                        //.showImageForEmptyUri(R.drawable.ic_empty)
                        //.showImageOnFail(R.drawable.ic_error)
                        //.displayer(new RoundedBitmapDisplayer(100))//是否设置为圆角，弧度为多少
                        //.delayBeforeLoading(1000)
                .resetViewBeforeLoading(true)  // default
                .cacheInMemory(true) // default
                .cacheOnDisc(true) // default
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new FadeInBitmapDisplayer(500))//是否图片加载好后渐入的动画时间
                .build();

        ImageLoaderConfiguration config;
        config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .diskCacheExtraOptions(480, 800, null)
                .threadPoolSize(5)//线程池内加载的数量
                .threadPriority(Thread.MIN_PRIORITY)
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .memoryCacheSize(2*1024*1024)
                .memoryCacheSizePercentage(13) // default
//                .diskCache(new UnlimitedDiscCache(cacheDir)) // default
                .diskCacheSize(50*1024*1024)
                .diskCacheFileCount(50)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(context, 5*1000, 30*1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .defaultDisplayImageOptions(options) // default
                        //.writeDebugLogs()
                .build();

        ImageLoader il= ImageLoader.getInstance();

        il.init(config);
        return il;
    }

    public static ImageLoader Instance(Context context, int defaultImageID){

        /**
         * 參考
         * http://blog.csdn.net/vipzjyno1/article/details/23206387
         */

        File cacheDir = StorageUtils.getCacheDirectory(context);

        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        builder.resetViewBeforeLoading(true)  // default
                .cacheInMemory(true) // default
                .cacheOnDisc(true) // default
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new FadeInBitmapDisplayer(500));//是否图片加载好后渐入的动画时间

        if (defaultImageID != 0) builder.showImageForEmptyUri(defaultImageID);

        DisplayImageOptions options = builder.build();

        ImageLoaderConfiguration config;
        config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .diskCacheExtraOptions(480, 800, null)
                .threadPoolSize(5)//线程池内加载的数量
                .threadPriority(Thread.MIN_PRIORITY)
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .memoryCacheSize(2*1024*1024)
                .memoryCacheSizePercentage(13) // default
//                .diskCache(new UnlimitedDiscCache(cacheDir)) // default
                .diskCacheSize(50*1024*1024)
                .diskCacheFileCount(50)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(context, 5*1000, 30*1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .defaultDisplayImageOptions(options) // default
                        //.writeDebugLogs()
                .build();

        ImageLoader il= ImageLoader.getInstance();

        il.init(config);
        return il;
    }
}
