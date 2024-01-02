package 操作系统课设;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 小何
 * @Description : 在其他条件都相同时，应优先淘汰没有修改过的页面
 * @date : 2023-12-30 19:21
 */
public class ImproveClockQueue {
    public static class Page {
        /**
         * 该page的页号
         */
        public int pageId;
        /**
         * 访问位
         */
        public int read;

        /**
         * 修改位
         * 修改位=0，表示页面没有被修改过；
         * 修改位=1，表示页面被修改过。
         */
        public int write;


        public Page(int pageId, int read) {
            this.pageId = pageId;
            this.read = read;
        }

        public Page() {
        }
    }

    public List<Page> allPages;
    public int memorySize;

    public int currentPage;

    public ImproveClockQueue(int memorySize) {
        this.memorySize = memorySize;
        this.currentPage = 0;
        this.allPages = new ArrayList<>();
    }

    /**
     * 判断某个页是否在内存中
     *
     * @param pageId
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


    public boolean setConfirm(Integer pageId, Integer type) {
        for (int i = 0; i < allPages.size(); i++) {
            Page page = allPages.get(i);
            if (page != null && page.pageId == pageId) {
                page.read = 1;
                if (type == 1) {
                    page.write = 1;
                }
                return true;
            }
        }
        return false;
    }


    /**
     * 添加页面
     *
     * @param pageId 页号
     * @param type   类型，有读写两种类型
     *               0 : 读
     *               1 : 写
     */
    public boolean addPage(Integer pageId, int type) {
        Page page = new Page();
        page.pageId = pageId;
        page.read = 1;
        page.write = type == 1 ? 1 : 0;
        allPages.add(page);

        return true;
    }

    public boolean setCurrent(Integer pageId, int type) {
        // 有四轮扫描
        if (scanOne(pageId, type)) {
            return true;
        }
        if (scanTwo(pageId, type)) {
            return true;
        }
        if (scanOne(pageId, type)) {
            return true;
        }
        if (scanTwo(pageId, type)) {
            return false;
        }
        return false;
    }

    // 从当前位置开始扫描到第一个（0, 0）的帧用于替换。本轮扫描不修改任何标志位。
    public boolean scanOne(Integer pageId, Integer type) {
        int flag = currentPage + size();
        while (currentPage < flag) {
            Page page = allPages.get(currentPage % size());
            if (page.read == 0 && page.write == 0) {
                // 开始置换
                page.read = 1;
                if (type == 1) {
                    page.write = 1;
                }
                page.pageId = pageId;
                return true;
            }
            currentPage += 1;
        }
        currentPage = currentPage % size();
        return false;
    }

    // 查找第一个（0, 1）的帧用于替换。本轮将所有扫描过的帧访问位设为0。
    public boolean scanTwo(Integer pageId, Integer type) {
        currentPage = currentPage % size();
        int flag = currentPage + size();
        while (currentPage < flag) {
            Page page = allPages.get(currentPage % size());
            if (page.read == 0 && page.write == 1) {
                // 开始置换
                page.read = 1;
                if (type == 1) {
                    page.write = 1;
                }
                page.pageId = pageId;
                return true;
            } else {
                page.read = 0;
            }
            currentPage++;
        }
        currentPage = currentPage % size();
        return false;
    }

    public ArrayList<Integer> getPages() {
        ArrayList<Integer> pages = (ArrayList<Integer>) allPages.stream().map((page) -> {
            return page.pageId;
        }).collect(Collectors.toList());
        return pages;
    }

    // clock加强模式下的输入
    public static class In {
        public int pageId;
        // 0 : 读
        // 1 : 写
        public int type;

        public In() {
        }

        public In(int pageId, int type) {
            this.pageId = pageId;
            this.type = type;
        }

        public int getPageId() {
            return pageId;
        }

        public void setPageId(int pageId) {
            this.pageId = pageId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

}
