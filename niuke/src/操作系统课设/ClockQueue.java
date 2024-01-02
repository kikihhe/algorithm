package 操作系统课设;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-12-30 14:38
 */
public class ClockQueue {
    public static class Page {
        /**
         * 该page的页号
         */
        public int pageId;
        /**
         * 访问位
         */
        public int read;



        public Page(int pageId, int read) {
            this.pageId = pageId;
            this.read = read;
        }

        public Page() {
        }
    }

    public List<Page> allPages;

    /**
     * 内存大小
     */
    public int memorySize;

    public int currentPage;

    public ClockQueue(int memorySize) {
        allPages = new ArrayList<>(memorySize);
        this.memorySize = memorySize;
        this.currentPage = 0;
    }


    /**
     * 内存中是否含有指定页号的页
     * @param pageId
     * @return
     */
    public boolean containsPage(Integer pageId) {
        for (int i = 0; i < allPages.size(); i++) {
            if (allPages.get(i).pageId == pageId) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.allPages.size();
    }

    /**
     * 将页号为 pageId 的页的访问位置为1
     * @param pageId
     * @return
     */
    public boolean setConfirm(Integer pageId) {
        for (int i = 0; i < allPages.size(); i++) {
            Page page = allPages.get(i);
            if (page != null && page.pageId == pageId) {
                page.read = 1;
                return true;
            }
        }
        return false;
    }

    /**
     * 增加一个page
     * @param pageId
     * @return
     */
    public boolean addPage(Integer pageId) {
        Page page = new Page(pageId, 1);
        boolean add = allPages.add(page);
        currentPage = (currentPage + 1) % memorySize;
        return add;
    }

    /**
     * 当页面不存在时要进行替换
     * @param pageId
     * @return
     */
     public boolean putAtCurrent(Integer pageId) {
        // 从currentPage开始找
        // 1. 如果read为1,将其替换为0
        // 2. 如果read为0，将其替换
        boolean flag = true;
        while (flag) {
            Page page = allPages.get(currentPage);
            if (page.read == 1) {
                page.read = 0;
            } else {
                page.pageId = pageId;
                page.read = 1;
                flag = false;
            }
            currentPage = (currentPage + 1) % memorySize;
        }
        return true;
    }

    public ArrayList<Integer> getPages() {
        return (ArrayList<Integer>) allPages.stream().map(page -> {
             return page.pageId;
         }).collect(Collectors.toList());
    }

}
