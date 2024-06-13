package com.example.buspassapplication.screens.Routes

class Data {
    companion object {
        val busOptions: List<String> = listOf(
            "9X",
            "10H/16H",
            "127K",
            "127J",
            "115",
            "127J/K",
            "187D/V",
            "225D",
            "226",
            "1J",
            "1P/25I",
            "1V",
            "2C",
            "2J",
            "2U",
            "2Z",
            "3",
            "3D",
            "3H",
            "3K",
            "3KJ",
            "5K",
            "5M",
            "1R",
            "5R",
            "5S",
            "6H",
            "6B",
            "8A",
            "8C/229",
            "8M",
            "8R",
            "8R/21",
            "8R/25",
            "9F",
            "9K",
            "9K/B",
            "9M",
            "9X",
            "9Y",
            "10",
            "10F",
            "10/16",
            "10FY",
            "10H",
            "10K",
            "16",
            "16/49M",
            "16K",
            "17H",
            "17H/",
            "226C",
            "18"
        )
        val busNoRouteList: MutableMap<String, List<String>> = hashMapOf(
            "9X" to listOf("charminar", "afzalgunj", "erragadda", "shapur", "jeedimetla"),
            "10H/16H" to listOf("kondapur", "kothaguda", "ameerpet", "east anandbagh", "ecil x rd"),
            "127K" to listOf("kondapur", "hi-tech city", "m.tank", "malakpet", "dilsukhnagar"),
            "127J" to listOf("vit.park(kondapur)", "kondapur", "mla colony"),
            "115" to listOf("koti", "ramantapur", "uppal"),
            "127J/K" to listOf("dilsukhnagar", "nglx rd", "m.tank", "peddamaguddi", "kondapur"),
            "187D/V" to listOf("ngo's colony", "dsnr", "abids", "ameerpet", "kphb colony"),
            "225D" to listOf("dilsukhnagar", "ngl x rd", "kukatpally bhel", "patancheru"),
            "226" to listOf(
                "patancheru",
                "R.C.Puram",
                "kukatpally",
                "paradise",
                "secunderabad junction"
            ),
            "1J" to listOf(
                "jiyaguda",
                "afg",
                "koti",
                "ymca",
                "ch.pally",
                "rtc'x'rd",
                "msrd",
                "padmaraonagar",
                "secunderabad"
            ),
            "1P/25I" to listOf(
                "alwal",
                "jbs",
                "patny",
                "secunderabad",
                "chilkalguda",
                "padmaraonagar",
                "msrd",
                "rtc'x'road",
                "ymca",
                "koti"
            ),
            "1V" to listOf(
                "ngo's colony",
                "l.b.nagar",
                "dsn",
                "mallampet",
                "ch.ghat",
                "koti",
                "ymca",
                "rtc'x'road",
                "msrd",
                "secunderabad",
                "afg",
                "cbs",
                "ymca",
                "ch.pally",
                "rtc'x'rod",
                "msrd",
                "secunderabad",
                "jbs",
                "lalbazar",
                "yapral"
            ),
            "2C" to listOf(
                "secunderabad",
                "rtc'x'road",
                "s mutt",
                "bkp k guda",
                "imlibun",
                "afg",
                "chudi bazar",
                "jiaguda"
            ),
            "2J" to listOf(
                "secunderabad",
                "msrd",
                "rtc'x'road",
                "s mutt",
                "bkp",
                "k.guda",
                "imlibun",
                "afg",
                "cmnr",
                "c.gutta",
                "barkas"
            ),
            "2U" to listOf(
                "uppuguda",
                "cmnr",
                "kachiguda",
                "s.mutt",
                "rtc'x'road",
                "msrd",
                "secunderabad"
            ),
            "2Z" to listOf(
                "madhuban colony",
                "cmnr",
                "kachiguda",
                "s.mutt",
                "rtc'x'road",
                "msrd",
                "secunderabad"
            ),
            "3" to listOf("kusha iguda", "moulaali", "tarnaka", "o.u", "ymca", "koti", "afg"),
            "3D" to listOf(
                "dammaiguda",
                "nagaram",
                "moula ali",
                "tarnaka",
                "vidya nagar",
                "koti",
                "afzalgunj"
            ),
            "3H" to listOf(
                "ecil'x'road",
                "moula ali",
                "tarnaka",
                "o.u",
                "ymca",
                "koti",
                "afzalgunj"
            ),
            "3K" to listOf(
                "kushaiguda",
                "moula ali",
                "tarnaka",
                "o.u",
                "ymca",
                "koti",
                "afzalgunj"
            ),
            "3KJ" to listOf(
                "kushaiguda",
                "ecil",
                "tarnaka",
                "afzalgunj",
                "jumarathbazar",
                "jiyaguda"
            ),
            "5K" to listOf(
                "mehandipatnam",
                "masab tank",
                "lakdi ka pool",
                "boats club",
                "sangeeth",
                "secunderabad station",
                "afg",
                "madina",
                "city college",
                "bahadurpura",
                "zoo park"
            ),
            "5M" to listOf(
                "secunderabad",
                "paradise",
                "rng",
                "tank bund",
                "secretariat",
                "birla mandir"
            ),
            "1R" to listOf(
                "lakdi ka pool",
                "golconda hotel",
                "nmdc",
                "mehandipatnam",
                "tolichowki"
            ),
            "5R" to listOf(
                "risala bazar",
                "bolaram",
                "lalbazar",
                "jbs",
                "bata",
                "tank bund",
                "secretariat",
                "lakdi ka pool",
                "masab tank",
                "mehandipatnam",
                "l.houz"
            ),
            "5S" to listOf(
                "ecil'x'road",
                "sainikpuri",
                "neredmet",
                "malkajgiri",
                "secunderabad",
                "masab tank",
                "mehandipatnam"
            ),
            "6H" to listOf(
                "mehandipatnam",
                "masab tank",
                "secretariat",
                "h.b.colony",
                "ecil'x'road"
            ),
            "6B" to listOf(
                "ramnagar",
                "bachupally",
                "n.guda",
                "lakdi ka pool",
                "mehandipatnam",
                "ocean park"
            ),
            "8A" to listOf(
                "secunderabad station",
                "bata",
                "tankbund",
                "liberty",
                "abids",
                "afzalgunj",
                "charminar"
            ),
            "8C/229" to listOf(
                "medchal",
                "kompally",
                "secunderabad station",
                "nampally",
                "afzalgunj",
                "charminar"
            ),
            "8M" to listOf(
                "secunderabad station",
                "bata",
                "tank bund",
                "ag-office",
                "nampally",
                "afzalgunj",
                "charminar"
            ),
            "8R" to listOf(
                "risalabazar",
                "bollaram",
                "jbs",
                "nampally",
                "afzalgunj",
                "madina",
                "charminar"
            ),
            "8R/21" to listOf(
                "venkatapur",
                "alwal",
                "jbs",
                "nampally",
                "afzalgunj",
                "madina",
                "charminar"
            ),
            "8R/25" to listOf("oldalwal", "nampally", "afzalgunj", "charminar"),
            "9F" to listOf("borabanda", "erragadda", "nampally", "m.j.market"),
            "9K" to listOf(
                "apurupa colony",
                "jeedimetla",
                "moosapet",
                "abids",
                "koti",
                "afzalgunj",
                "charminar"
            ),
            "9K/B" to listOf(
                "balanagar",
                "moosapet",
                "k.bad",
                "abids",
                "koti",
                "afzalgunj",
                "charminar"
            ),
            "9M" to listOf(
                "charminar",
                "afzalgunj",
                "nampally",
                "punjagutta",
                "erragadda",
                "sanathnagar"
            ),
            "9X" to listOf(
                "apurupa colony",
                "jeedimetla",
                "moosapet",
                "nampally",
                "afzalgunj",
                "charminar",
                "afzalgunj",
                "lakdi ka pool",
                "moosapet",
                "idpl",
                "balanagar"
            ),
            "9Y" to listOf(
                "yousufguda",
                "ameerpet",
                "nampally",
                "m.market",
                "afzalgunj",
                "charminar"
            ),
            "10" to listOf(
                "secunderabad station",
                "paradise",
                "begumpet",
                "esi",
                "erragadda",
                "sanathnagar"
            ),
            "10F" to listOf(
                "borabanda",
                "erragadda",
                "esi",
                "paradise",
                "patny",
                "secunderabad station"
            ),
            "10/16" to listOf(
                "sanathnagar",
                "erragadda",
                "begumpet",
                "patny",
                "n.mutt",
                "ecil'x'road"
            ),
            "10FY" to listOf(
                "borabanda",
                "rahamah nagar",
                "begumpet",
                "paradise",
                "patny",
                "secunderabad station"
            ),
            "10H" to listOf(
                "secunderabad station",
                "patny",
                "cyber towers",
                "kothaguda 'x' road",
                "kondapur"
            ),
            "10K" to listOf(
                "kphb colony",
                "kukatpally",
                "ameerpet",
                "green lands",
                "sangeeth",
                "secunderabad station"
            ),
            "16" to listOf(
                "ap",
                "ecil'x'road",
                "neredmet",
                "secunderabad station",
                "plaza",
                "airport"
            ),
            "16/49M" to listOf("neredmet", "safilguda", "secunderabad station", "plaza", "airport"),
            "16K" to listOf(
                "neredmet'x'road",
                "safilguda",
                "malkajgiri",
                "mettuguda",
                "msrd",
                "rtc",
                "koti",
                "mallampet",
                "dilsukhnagar"
            ),
            "17H" to listOf(
                "kg",
                "h.b.colony",
                "jts",
                "rly qtrs",
                "lalapet",
                "tnk",
                "mettuguda",
                "secunderabad"
            ),
            "17H/" to listOf("ecil'x'road", "moulali", "h.b.colony", "tnk"),
            "226C" to listOf(
                "secunderabad",
                "boyanpally",
                "balanagar",
                "kukatpally",
                "kphb",
                "miyapur",
                "bhel"
            ),
            "18" to listOf(
                "secunderabad",
                "mettuguda",
                "hubsiguda",
                "uppal'x'road",
                "uppal",
                "upl depot"
            ),


            )
        val busNoRouteSet: MutableMap<String, HashSet<String>> = hashMapOf(
            "9X" to hashSetOf("charminar", "afzalgunj", "erragadda", "shapur", "jeedimetla"),
            "10H/16H" to hashSetOf(
                "kondapur",
                "kothaguda",
                "ameerpet",
                "east anandbagh",
                "ecil x rd"
            ),
            "127K" to hashSetOf("kondapur", "hi-tech city", "m.tank", "malakpet", "dilsukhnagar"),
            "127J" to hashSetOf("vit.park(kondapur)", "kondapur", "mla colony"),
            "115" to hashSetOf("koti", "ramantapur", "uppal"),
            "127J/K" to hashSetOf("dilsukhnagar", "nglx rd", "m.tank", "peddamaguddi", "kondapur"),
            "187D/V" to hashSetOf("ngo's colony", "dsnr", "abids", "ameerpet", "kphb colony"),
            "225D" to hashSetOf("dilsukhnagar", "ngl x rd", "kukatpally bhel", "patancheru"),
            "226" to hashSetOf(
                "patancheru",
                "R.C.Puram",
                "kukatpally",
                "paradise",
                "secunderabad junction"
            ),
            "1J" to hashSetOf(
                "jiyaguda",
                "afg",
                "koti",
                "ymca",
                "ch.pally",
                "rtc'x'rd",
                "msrd",
                "padmaraonagar",
                "secunderabad"
            ),
            "1P/25I" to hashSetOf(
                "alwal",
                "jbs",
                "patny",
                "secunderabad",
                "chilkalguda",
                "padmaraonagar",
                "msrd",
                "rtc'x'road",
                "ymca",
                "koti"
            ),
            "1V" to hashSetOf(
                "ngo's colony",
                "l.b.nagar",
                "dsn",
                "mallampet",
                "ch.ghat",
                "koti",
                "ymca",
                "rtc'x'road",
                "msrd",
                "secunderabad",
                "afg",
                "cbs",
                "ymca",
                "ch.pally",
                "rtc'x'rod",
                "msrd",
                "secunderabad",
                "jbs",
                "lalbazar",
                "yapral"
            ),
            "2C" to hashSetOf(
                "secunderabad",
                "rtc'x'road",
                "s mutt",
                "bkp k guda",
                "imlibun",
                "afg",
                "chudi bazar",
                "jiaguda"
            ),
            "2J" to hashSetOf(
                "secunderabad",
                "msrd",
                "rtc'x'road",
                "s mutt",
                "bkp",
                "k.guda",
                "imlibun",
                "afg",
                "cmnr",
                "c.gutta",
                "barkas"
            ),
            "2U" to hashSetOf(
                "uppuguda",
                "cmnr",
                "kachiguda",
                "s.mutt",
                "rtc'x'road",
                "msrd",
                "secunderabad"
            ),
            "2Z" to hashSetOf(
                "madhuban colony",
                "cmnr",
                "kachiguda",
                "s.mutt",
                "rtc'x'road",
                "msrd",
                "secunderabad"
            ),
            "3" to hashSetOf("kusha iguda", "moulaali", "tarnaka", "o.u", "ymca", "koti", "afg"),
            "3D" to hashSetOf(
                "dammaiguda",
                "nagaram",
                "moula ali",
                "tarnaka",
                "vidya nagar",
                "koti",
                "afzalgunj"
            ),
            "3H" to hashSetOf(
                "ecil'x'road",
                "moula ali",
                "tarnaka",
                "o.u",
                "ymca",
                "koti",
                "afzalgunj"
            ),
            "3K" to hashSetOf(
                "kushaiguda",
                "moula ali",
                "tarnaka",
                "o.u",
                "ymca",
                "koti",
                "afzalgunj"
            ),
            "3KJ" to hashSetOf(
                "kushaiguda",
                "ecil",
                "tarnaka",
                "afzalgunj",
                "jumarathbazar",
                "jiyaguda"
            ),
            "5K" to hashSetOf(
                "mehandipatnam",
                "masab tank",
                "lakdi ka pool",
                "boats club",
                "sangeeth",
                "secunderabad station",
                "afg",
                "madina",
                "city college",
                "bahadurpura",
                "zoo park"
            ),
            "5M" to hashSetOf(
                "secunderabad",
                "paradise",
                "rng",
                "tank bund",
                "secretariat",
                "birla mandir"
            ),
            "1R" to hashSetOf(
                "lakdi ka pool",
                "golconda hotel",
                "nmdc",
                "mehandipatnam",
                "tolichowki"
            ),
            "5R" to hashSetOf(
                "risala bazar",
                "bolaram",
                "lalbazar",
                "jbs",
                "bata",
                "tank bund",
                "secretariat",
                "lakdi ka pool",
                "masab tank",
                "mehandipatnam",
                "l.houz"
            ),
            "5S" to hashSetOf(
                "ecil'x'road",
                "sainikpuri",
                "neredmet",
                "malkajgiri",
                "secunderabad",
                "masab tank",
                "mehandipatnam"
            ),
            "6H" to hashSetOf(
                "mehandipatnam",
                "masab tank",
                "secretariat",
                "h.b.colony",
                "ecil'x'road"
            ),
            "6B" to hashSetOf(
                "ramnagar",
                "bachupally",
                "n.guda",
                "lakdi ka pool",
                "mehandipatnam",
                "ocean park"
            ),
            "8A" to hashSetOf(
                "secunderabad station",
                "bata",
                "tankbund",
                "liberty",
                "abids",
                "afzalgunj",
                "charminar"
            ),
            "8C/229" to hashSetOf(
                "medchal",
                "kompally",
                "secunderabad station",
                "nampally",
                "afzalgunj",
                "charminar"
            ),
            "8M" to hashSetOf(
                "secunderabad station",
                "bata",
                "tank bund",
                "ag-office",
                "nampally",
                "afzalgunj",
                "charminar"
            ),
            "8R" to hashSetOf(
                "risalabazar",
                "bollaram",
                "jbs",
                "nampally",
                "afzalgunj",
                "madina",
                "charminar"
            ),
            "8R/21" to hashSetOf(
                "venkatapur",
                "alwal",
                "jbs",
                "nampally",
                "afzalgunj",
                "madina",
                "charminar"
            ),
            "8R/25" to hashSetOf("oldalwal", "nampally", "afzalgunj", "charminar"),
            "9F" to hashSetOf("borabanda", "erragadda", "nampally", "m.j.market"),
            "9K" to hashSetOf(
                "apurupa colony",
                "jeedimetla",
                "moosapet",
                "abids",
                "koti",
                "afzalgunj",
                "charminar"
            ),
            "9K/B" to hashSetOf(
                "balanagar",
                "moosapet",
                "k.bad",
                "abids",
                "koti",
                "afzalgunj",
                "charminar"
            ),
            "9M" to hashSetOf(
                "charminar",
                "afzalgunj",
                "nampally",
                "punjagutta",
                "erragadda",
                "sanathnagar"
            ),
            "9X" to hashSetOf(
                "apurupa colony",
                "jeedimetla",
                "moosapet",
                "nampally",
                "afzalgunj",
                "charminar",
                "afzalgunj",
                "lakdi ka pool",
                "moosapet",
                "idpl",
                "balanagar"
            ),
            "9Y" to hashSetOf(
                "yousufguda",
                "ameerpet",
                "nampally",
                "m.market",
                "afzalgunj",
                "charminar"
            ),
            "10" to hashSetOf(
                "secunderabad station",
                "paradise",
                "begumpet",
                "esi",
                "erragadda",
                "sanathnagar"
            ),
            "10F" to hashSetOf(
                "borabanda",
                "erragadda",
                "esi",
                "paradise",
                "patny",
                "secunderabad station"
            ),
            "10/16" to hashSetOf(
                "sanathnagar",
                "erragadda",
                "begumpet",
                "patny",
                "n.mutt",
                "ecil'x'road"
            ),
            "10FY" to hashSetOf(
                "borabanda",
                "rahamah nagar",
                "begumpet",
                "paradise",
                "patny",
                "secunderabad station"
            ),
            "10H" to hashSetOf(
                "secunderabad station",
                "patny",
                "cyber towers",
                "kothaguda 'x' road",
                "kondapur"
            ),
            "10K" to hashSetOf(
                "kphb colony",
                "kukatpally",
                "ameerpet",
                "green lands",
                "sangeeth",
                "secunderabad station"
            ),
            "16" to hashSetOf(
                "ap",
                "ecil'x'road",
                "neredmet",
                "secunderabad station",
                "plaza",
                "airport"
            ),
            "16/49M" to hashSetOf(
                "neredmet",
                "safilguda",
                "secunderabad station",
                "plaza",
                "airport"
            ),
            "16K" to hashSetOf(
                "neredmet'x'road",
                "safilguda",
                "malkajgiri",
                "mettuguda",
                "msrd",
                "rtc",
                "koti",
                "mallampet",
                "dilsukhnagar"
            ),
            "17H" to hashSetOf(
                "kg",
                "h.b.colony",
                "jts",
                "rly qtrs",
                "lalapet",
                "tnk",
                "mettuguda",
                "secunderabad"
            ),
            "17H/" to hashSetOf("ecil'x'road", "moulali", "h.b.colony", "tnk"),
            "226C" to hashSetOf(
                "secunderabad",
                "boyanpally",
                "balanagar",
                "kukatpally",
                "kphb",
                "miyapur",
                "bhel"
            ),
            "18" to hashSetOf(
                "secunderabad",
                "mettuguda",
                "hubsiguda",
                "uppal'x'road",
                "uppal",
                "upl depot"
            )
        )
    }
}
