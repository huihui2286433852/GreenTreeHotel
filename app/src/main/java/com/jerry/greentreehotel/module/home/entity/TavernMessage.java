package com.jerry.greentreehotel.module.home.entity;

import java.util.List;

/**
 * Created by huanghui on 2016/4/28.
 */
public class TavernMessage{

    /**
     * result : 0
     * message : 接口通信成功！
     * responseData : {"totalItems":"87","totalPage":"18","currentPage":"1","items":[{"id":"122291","name":"格林豪泰北京市通州区马驹桥2号桥快捷酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/122291/Logo/Logo_122291_1.jpg","score":"4.4","distance":"","price":"199","isFull":"false","longitude":"116.563753","latitude":"39.755982","service":["41","51","72"],"isPromotion":"false"},{"id":"122436","name":"格林豪泰北京市海淀区石景山北方工业大学快捷酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/122436/Logo/Logo_122436_1.jpg","score":"4.2","distance":"","price":"168","isFull":"false","longitude":"116.213798","latitude":"39.926051","service":["41","51","72"],"isPromotion":"true"},{"id":"122373","name":"格林豪泰北京市大兴区榆垡镇新机场快捷酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/122373/Logo/Logo_122373_1.jpg","score":"5","distance":"","price":"152","isFull":"false","longitude":"116.33016","latitude":"39.516504","service":["41","51","72"],"isPromotion":"false"},{"id":"121142","name":"格林豪泰北京市昌平区沙河镇朱辛庄地铁站快捷酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/121142/Logo/Logo_121142_1.jpg","score":"4.7","distance":"","price":"99.8","isFull":"false","longitude":"116.297455","latitude":"40.116888","service":["41","51","72","91"],"isPromotion":"false"},{"id":"120447","name":"格林豪泰北京市学院路五道口地铁站商务酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/120447/Logo/Logo_120447_1.jpg","score":"4.7","distance":"","price":"246","isFull":"false","longitude":"116.34707","latitude":"39.994281","service":["41","51","72","91"],"isPromotion":"false"}]}
     */

    private String result;
    private String message;
    /**
     * totalItems : 87
     * totalPage : 18
     * currentPage : 1
     * items : [{"id":"122291","name":"格林豪泰北京市通州区马驹桥2号桥快捷酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/122291/Logo/Logo_122291_1.jpg","score":"4.4","distance":"","price":"199","isFull":"false","longitude":"116.563753","latitude":"39.755982","service":["41","51","72"],"isPromotion":"false"},{"id":"122436","name":"格林豪泰北京市海淀区石景山北方工业大学快捷酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/122436/Logo/Logo_122436_1.jpg","score":"4.2","distance":"","price":"168","isFull":"false","longitude":"116.213798","latitude":"39.926051","service":["41","51","72"],"isPromotion":"true"},{"id":"122373","name":"格林豪泰北京市大兴区榆垡镇新机场快捷酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/122373/Logo/Logo_122373_1.jpg","score":"5","distance":"","price":"152","isFull":"false","longitude":"116.33016","latitude":"39.516504","service":["41","51","72"],"isPromotion":"false"},{"id":"121142","name":"格林豪泰北京市昌平区沙河镇朱辛庄地铁站快捷酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/121142/Logo/Logo_121142_1.jpg","score":"4.7","distance":"","price":"99.8","isFull":"false","longitude":"116.297455","latitude":"40.116888","service":["41","51","72","91"],"isPromotion":"false"},{"id":"120447","name":"格林豪泰北京市学院路五道口地铁站商务酒店","imageUrl":"http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/120447/Logo/Logo_120447_1.jpg","score":"4.7","distance":"","price":"246","isFull":"false","longitude":"116.34707","latitude":"39.994281","service":["41","51","72","91"],"isPromotion":"false"}]
     */

    private ResponseDataBean responseData;

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public ResponseDataBean getResponseData(){
        return responseData;
    }

    public void setResponseData(ResponseDataBean responseData){
        this.responseData = responseData;
    }

    public static class ResponseDataBean{
        private String totalItems;
        private String totalPage;
        private String currentPage;
        /**
         * id : 122291
         * name : 格林豪泰北京市通州区马驹桥2号桥快捷酒店
         * imageUrl : http://a3.greentree.cn:8022/UploadFiles/CRS/HotelImg/122291/Logo/Logo_122291_1.jpg
         * score : 4.4
         * distance :
         * price : 199
         * isFull : false
         * longitude : 116.563753
         * latitude : 39.755982
         * service : ["41","51","72"]
         * isPromotion : false
         */

        private List<ItemsBean> items;

        public String getTotalItems(){
            return totalItems;
        }

        public void setTotalItems(String totalItems){
            this.totalItems = totalItems;
        }

        public String getTotalPage(){
            return totalPage;
        }

        public void setTotalPage(String totalPage){
            this.totalPage = totalPage;
        }

        public String getCurrentPage(){
            return currentPage;
        }

        public void setCurrentPage(String currentPage){
            this.currentPage = currentPage;
        }

        public List<ItemsBean> getItems(){
            return items;
        }

        public void setItems(List<ItemsBean> items){
            this.items = items;
        }

        public static class ItemsBean{
            private String id;
            private String name;
            private String imageUrl;
            private String score;
            private String distance;
            private String price;
            private String isFull;
            private String longitude;
            private String latitude;
            private String isPromotion;
            private List<String> service;

            public String getId(){
                return id;
            }

            public void setId(String id){
                this.id = id;
            }

            public String getName(){
                return name;
            }

            public void setName(String name){
                this.name = name;
            }

            public String getImageUrl(){
                return imageUrl;
            }

            public void setImageUrl(String imageUrl){
                this.imageUrl = imageUrl;
            }

            public String getScore(){
                return score;
            }

            public void setScore(String score){
                this.score = score;
            }

            public String getDistance(){
                return distance;
            }

            public void setDistance(String distance){
                this.distance = distance;
            }

            public String getPrice(){
                return price;
            }

            public void setPrice(String price){
                this.price = price;
            }

            public String getIsFull(){
                return isFull;
            }

            public void setIsFull(String isFull){
                this.isFull = isFull;
            }

            public String getLongitude(){
                return longitude;
            }

            public void setLongitude(String longitude){
                this.longitude = longitude;
            }

            public String getLatitude(){
                return latitude;
            }

            public void setLatitude(String latitude){
                this.latitude = latitude;
            }

            public String getIsPromotion(){
                return isPromotion;
            }

            public void setIsPromotion(String isPromotion){
                this.isPromotion = isPromotion;
            }

            public List<String> getService(){
                return service;
            }

            public void setService(List<String> service){
                this.service = service;
            }
        }
    }
}
