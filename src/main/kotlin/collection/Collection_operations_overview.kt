package org.example.collection

// 問題1: リストのフィルタリングと変換
fun main1() {
    val products = listOf(
        mapOf("name" to "Laptop", "price" to 1200, "category" to "Electronics"),
        mapOf("name" to "T-Shirt", "price" to 25, "category" to "Apparel"),
        mapOf("name" to "Mouse", "price" to 50, "category" to "Electronics"),
        mapOf("name" to "Jeans", "price" to 75, "category" to "Apparel"),
        mapOf("name" to "Keyboard", "price" to 100, "category" to "Electronics")
    )

    // 問1-1: カテゴリが "Electronics" の製品のみを抽出し、その製品名（name）のリストをpricesOfElectronicsという変数に格納して出力してください。
    // 例: [Laptop, Mouse, Keyboard]
    // val pricesOfElectronics = ...
    // println(pricesOfElectronics)
    val pricesOfElectronics = products.filter { it["category"] == "Electronics" }.map { it["name"] }
    println(pricesOfElectronics)

    // 問1-2: 価格が50より大きい製品のみを抽出し、その製品名と価格を文字列で結合したリストを作成し、
    // highValueProductsという変数に格納して出力してください。
    // 例: [Laptop (1200), Jeans (75), Keyboard (100)]
    // val highValueProducts = ...
    // println(highValueProducts)
    val highValueProducts =
        products.filter { (it["price"] as Int )> 50 }.map { "${it["name"]}（${it["price"]}）" }
    println(highValueProducts)
}

// 問題2: 可変リストの操作とソート
fun main2() { // main関数が重複するため、コメントアウトするか、別のファイルに分けてください
    val studentScores = mutableListOf(
        mapOf("name" to "Alice", "score" to 85),
        mapOf("name" to "Bob", "score" to 92),
        mapOf("name" to "Charlie", "score" to 78),
        mapOf("name" to "David", "score" to 92)
    )

    // 問2-1: studentScoresリストに、以下の新しい学生の情報を追加してください。
    // 名前: "Eve", スコア: 88
    // studentScores.add(...)
    // println(studentScores) // 追加後のリストを出力
    studentScores.add(mapOf("name" to "Eve", "score" to 88))
    println(studentScores)

    // 問2-2: studentScoresリストから、スコアが90以上の学生のみを抽出し、
    // その学生のリストをhighAchieversという変数に格納して出力してください。
    // 元のstudentScoresリストは変更しないこと。
    // val highAchievers = ...
    // println(highAchievers)
    val highAchievers = studentScores.filter { (it["score"] as Int )>= 90 }.map { it }
    println(highAchievers)

    // 問2-3: studentScoresリストをスコアの降順（高い順）でソートし、もしスコアが同じ場合は名前の昇順（アルファベット順）でソートしてください。
    // そして、ソート後のstudentScoresリストを直接変更して出力してください。
    // studentScores.sortWith(...)
    // println(studentScores) // ソート後のリストを出力
    studentScores.sortWith(compareByDescending<Map<String, Any>> { it["score"] as Int }.thenBy { it["name"] as String })
    println(studentScores)

}