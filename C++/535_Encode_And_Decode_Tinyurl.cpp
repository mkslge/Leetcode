class Solution {
public:
    std::unordered_map<std::string, std::string> short_to_long; 
    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        std::string short_url = genRandomUrl();
        short_to_long[short_url] = longUrl;
        return short_url;
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        return short_to_long[shortUrl];
    }

    std::string genRandomUrl() {
        std::string str;
        do {
            for(int i = 0; i < 5;i++) {
                char rch = 'a' + (rand() % 26);
                str.push_back(rch);
            }
        } while(short_to_long.contains(str));

        return str;
    }
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));
