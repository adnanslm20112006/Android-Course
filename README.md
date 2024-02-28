بدعنا نقسّم وظيفة Dice() في الشيفرة المقدمة:


    @Composable
    fun Dice() {
            Box(modifier = Modifier.fillMaxSize()) {
    
            // تعريف متغير قابل للتعديل لتخزين رقم النرد الحالي
            var number by remember { mutableIntStateOf((1..6).random()) }
            
            // قائمة بالمصادر القابلة للرسم لوجوه النرد
            val images = listOf(
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
            )
            
            // تركيبة لترتيب المحتوى بشكل عمودي
            Column(modifier = Modifier.align(Alignment.Center)) {
                // عرض صورة النرد بناءً على الرقم الحالي
                Image(
                    painter = painterResource(id = images[number - 1]),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                // عرض الرقم الذي تم الرمي به
                Text(
                    text = "تم الرمي بالرقم: $number",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                
                // زر لرمي النرد
                Button(
                    onClick = { number = (1..6).random() }, // توليد رقم عشوائي بين 1 و 6
                    modifier = Modifier
                        .widthIn(150.dp) // تحديد العرض الأدنى للزر
                        .align(Alignment.CenterHorizontally) // محاذاة الزر بالوسط
                        .padding(top = 24.dp) // إضافة حشوة من الأعلى
                ) {
                    Text("رمي", fontSize = 24.sp)
                }
            }
        }
    }
  وإليك شرح موجز لما يحدث:
  
  1- Box: هي عبارة عن حاوية ترتبط أطفالها فوق بعضها البعض. وهي تستخدم المساحة المتاحة بالكامل (fillMaxSize()).
  
  2- var number by remember { mutableIntStateOf((1..6).random()) }: هذا السطر يعرّف متغيرًا قابلًا للتعديل يسمى number باستخدام mutableIntStateOf، ويتم تهيئته برقم عشوائي بين 1 و 6. وظيفة remember تضمن أن قيمة number تُذكر عبر عمليات الإعادة الرسم
  
  3- val images: قائمة تحتوي على المصادر القابلة للرسم لكل وجه من أوجه النرد.
  
  4- Column: هذه التركيبة تُستخدم لترتيب العناصر الخاصة بها بتسلسل عمودي. وهي محاذاة في الوسط بالنسبة لـ Box.
  
  5- داخل Column، يوجد Image لعرض وجه النرد بناءً على الرقم الحالي، و Text لعرض الرقم الذي تم الرمي به، و Button لرمي النرد. كل عنصر محاذاة للوسط بشكل أفقي.
  
  6- عند النقر على الزر، يتم توليد رقم عشوائي جديد بين 1 و 6، محدثًا المتغير number ومستدعيًا عملية إعادة الرسم.








Let's break down the Dice() function in the provided code:


    @Composable
    fun Dice() {
        Box(modifier = Modifier.fillMaxSize()) {

            // Define a mutable variable to hold the current dice number
            var number by remember { mutableIntStateOf((1..6).random()) }
            
            // List of drawable resources for dice faces
            val images = listOf(
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
            )
            
            // Column composable to vertically arrange content
            Column(modifier = Modifier.align(Alignment.Center)) {
                // Display the dice image based on the current number
                Image(
                    painter = painterResource(id = images[number - 1]),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                // Display the rolled number
                Text(
                    text = "Rolled: $number",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                
                // Button to roll the dice
                Button(
                    onClick = { number = (1..6).random() }, // Generates a random number between 1 and 6
                    modifier = Modifier
                        .widthIn(150.dp) // Set minimum width of the button
                        .align(Alignment.CenterHorizontally) // Center align the button
                        .padding(top = 24.dp) // Add top padding
                ) {
                    Text("Roll", fontSize = 24.sp)
                }
            }
        }
    }

Here's a brief explanation of what's happening:

  1- Box: It's a container that stacks its children on top of each other. It's using the entire available space (fillMaxSize()).

  2- var number by remember { mutableIntStateOf((1..6).random()) }: This line defines a mutable state variable called number using mutableIntStateOf, initialized with a random number between 1 and 6. The remember function ensures that the value of number is remembered across recompositions.

  3- val images: A list containing drawable resources for each face of the dice.

  4- Column: This composable is used to arrange its children in a vertical sequence. It's centered in the parent Box.

  5- Inside the Column, there's an Image composable to display the dice face based on the current number, a Text composable to display the rolled number, and a Button composable to roll the dice. Each child is aligned to the center horizontally.

  6- When the Button is clicked, it generates a new random number between 1 and 6, updating the number variable and triggering a recomposition.

This Dice() function essentially creates a UI component for rolling a dice with a button to roll it and displays the rolled number along with the corresponding dice face image.
