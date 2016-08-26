/*
# Search results are ordered by score
# Pagination:
# 1) show 12 results per page,
#   but avoid the same host dominate the results on a page,
# 2) a host shows up at most once in a page if possible,
# 3) otherwise, preserve the ordering
input_csv_array = [
  "host_id,listing_id,score,city",
  "1,28,300.1,San Francisco",
  "4,5,209.1,San Francisco",
  "20,7,208.1,San Francisco",
  "23,8,207.1,San Francisco",
  "16,10,206.1,Oakland",
  "1,16,205.1,San Francisco",
  "1,31,204.6,San Francisco",
  "6,29,204.1,San Francisco",
  "7,20,203.1,San Francisco",
  "8,21,202.1,San Francisco",
  "2,18,201.1,San Francisco",
  "2,30,200.1,San Francisco",
  "15,27,109.1,Oakland",
  "10,13,108.1,Oakland",
  "11,26,107.1,Oakland",
  "12,9,106.1,Oakland",
  "13,1,105.1,Oakland",
  "22,17,104.1,Oakland",
  "1,2,103.1,Oakland",
  "28,24,102.1,Oakland",
  "18,14,11.1,San Jose",
  "6,25,10.1,Oakland",
  "19,15,9.1,San Jose",
  "3,19,8.1,San Jose",
  "3,11,7.1,Oakland",
  "27,12,6.1,Oakland",
  "1,3,5.1,Oakland",
  "25,4,4.1,San Jose",
  "5,6,3.1,San Jose",
  "29,22,2.1,San Jose",
  "30,23,1.1,San Jose"
]

--- PAGE ---
  "1,28,300.1,San Francisco",
  "4,5,209.1,San Francisco",
  "20,7,208.1,San Francisco",
  "23,8,207.1,San Francisco",
  "16,10,206.1,Oakland",

--- PAGE ---

--- PAGE ---

*/

import java.io.*;
import java.util.*;

class ListingInfo{
    public int host_id;
    public int listing_id;
    public double score;
    public String city;

    public String toString(){
        return String.format("%d, %d, %f, %s", host_id, listing_id, score, city);
    }
}

public class Listings {

    public static void printListings(ArrayList<ListingInfo> listings, int listingsPerPage){
        //# Search results are ordered by score
        //# Pagination:
        //# 1) show 12 results per page, but avoid the same host dominate the results on a page,
        //# 2) a host shows up at most once in a page if possible,
        //# 3) otherwise, preserve the ordering
        HashSet<Integer> displayedListings = new HashSet<Integer>();
        ArrayList<ListingInfo> repeatedHosts = new ArrayList<ListingInfo>();

        int numPages = listings.size() / listingsPerPage;
        boolean hasRemainder = listings.size() % listingsPerPage > 0;
        if (hasRemainder)
            ++numPages;
        int lastPage = numPages - 1;

        int index = 0;
        for (int i = 0 ; i < numPages; ++i){
            displayedListings.clear();
            System.out.println(" --- Page: "+ (i+1) +" --- ");

            boolean checkRepeated = true;
            if (i == lastPage && hasRemainder){
                listingsPerPage = listings.size() % listingsPerPage;
            }
            for (int l = 0 ; l < listingsPerPage; ++l, ++index){
                // try to print as many repeated as possible.
                if (checkRepeated) {
                    checkRepeated = false;
                    for (int d = 0; d < repeatedHosts.size() && l < listingsPerPage; ++d) {
                        ListingInfo repeatedInfo = repeatedHosts.get(d);
                        if (!displayedListings.contains(repeatedInfo.host_id) || i == lastPage) {
                            displayedListings.add(repeatedInfo.host_id);
                            System.out.println(1+l +") - "+ repeatedInfo.toString());
                            repeatedHosts.remove(d);
                            displayedListings.add(repeatedInfo.host_id);
                            --d; // repeat same index
                            ++l; // let the counter know we have printed a listing
                        }
                    }
                }

                if (l == listingsPerPage) //if we reached listingsPerPage amount of listings, continue to next page
                    continue;

                // print them in their original order;
                ListingInfo info = listings.get(index);
                if (displayedListings.contains(info.host_id)){
                    repeatedHosts.add(info);
                    --l; // let the counter know we didn't print a listing
                } else {
                    displayedListings.add(info.host_id);
                    System.out.println(1+l +") - "+info.toString());
                }
            }

        }
    }



    public static void main(String[] args) {
        String input_csv_array[] = {
                "1,28,300.1,San Francisco", //1
                "4,5,209.1,San Francisco", //2
                "20,7,208.1,San Francisco", // 3
                "23,8,207.1,San Francisco", // 4
                "16,10,206.1,Oakland",
                "1,16,205.1,San Francisco",
                "1,31,204.6,San Francisco",
                "6,29,204.1,San Francisco",
                "7,20,203.1,San Francisco",
                "8,21,202.1,San Francisco",
                "2,18,201.1,San Francisco",
                "2,30,200.1,San Francisco",
                "15,27,109.1,Oakland",
                "10,13,108.1,Oakland",
                "11,26,107.1,Oakland",
                "12,9,106.1,Oakland",
                "13,1,105.1,Oakland",
                "22,17,104.1,Oakland",
                "1,2,103.1,Oakland",
                "28,24,102.1,Oakland",
                "18,14,11.1,San Jose",
                "6,25,10.1,Oakland",
                "19,15,9.1,San Jose",
                "3,19,8.1,San Jose",
                "3,11,7.1,Oakland",
                "27,12,6.1,Oakland",
                "1,3,5.1,Oakland",
                "25,4,4.1,San Jose",
                "5,6,3.1,San Jose",
                "29,22,2.1,San Jose",
                "30,23,1.1,San Jose"
        };


        ArrayList <ListingInfo> listings = new ArrayList<ListingInfo>();
        for (String string : input_csv_array) {
            String infoStr[] = string.split(",");
            ListingInfo info = new ListingInfo();
            info.host_id = Integer.parseInt(infoStr[0]);
            info.listing_id = Integer.parseInt(infoStr[1]);
            info.score = Double.parseDouble(infoStr[2]);
            info.city = infoStr[3];
            listings.add(info);
        }

        printListings(listings, 12);
    }
}