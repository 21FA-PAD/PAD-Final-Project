# Android Material Design
- Main Concepts
  - Material as a metaphor
  - Bold graphic design
  - Meaningful motion

---
## Material
- Material Design is inspired by the physical world and its textures, including how they reflect light and cast shadows.
- Material surfaces reimagine the mediums of paper and ink.
- Implementing surfaces
	- Use the `elevation` attribute to cast  a shadow
	- [Elevation](https://material.io/design/environment/elevation.html)
    - [Light and shadows](https://material.io/design/environment/light-shadows.html#light)

---

## Bold Graphic Design
- Based on Gestalt Principles
	- Law of past experience  
	- Law of proximity
	- Law of similarity
	- These three can all be accomplished by using white space
- Layout Specifics
	- 8 dp grid - icons, spacing, padding, etc. are multiples of 8
	- Text has a 4 dp grid - text size is a multiple of 4
	- Keylines are used to horizontally or vertically align content
	- Use dimension files (`res/values/dimens`) to customize for your app

###  Color
- Material design encourages bold purposeful use of color
- Material design recommends
	- a primary color
	- accent color
- [The color system](https://material.io/design/color/the-color-system.html#color-usage-and-palettes)
- Define colors in colors.xml and apply to the theme


### Typography
- Default font is Roboto
- Need to consider both screen density but also user preferences
- Use SP (scale-independent pixels)
- Font characteristics
	- Roboto is a san serif type
	- Sans serif is more common in the web which is better with a range of screen densities
- Weight and style
	- Roboto has 4 distinct font families
	- Weight is the thickness - regular and bold but many fonts also have thin, light and black
	- Also have regular and italics
	- In Android you can chose
		- fontFamily which is the family and the weight
		- textStyle is normal or italic
- Font tips:
	- Limit your font palette
	- Try out your font on different devices with various screen densities
	- Look for unintended consequences
- Adding a custom font
	- Right click on `res` and select Android Resource Directory
  - Create a directory named font
	- Copy your font file into this folder and apply as a style attribute
- [Google Fonts](https://fonts.google.com)


### Images
- Imagery should contain information and reinforce brand
- Different types of images
	- Photography
	- [Icons](https://material.io/design/iconography/product-icons.html#design-principles)
		- Use [Material Design icons](https://fonts.google.com/icons)
- Sizing images
  - [ImageView.ScaleType | Android Developers](https://developer.android.com/reference/android/widget/ImageView.ScaleType.html)
  - Default size type is FIT_CENTER
 - FIT_XY might distort your image

---
##  Motion

- Material surfaces are not constrained by real-world physics
- Along with width and height, views can also change elevation

### Animation on Android
- [AnimationSet | Android Developers](https://developer.android.com/reference/android/view/animation/AnimationSet.html) lets you move,  scale and fade items on screen
- [TransitionManager | Android Developers](https://developer.android.com/reference/android/transition/TransitionManager.html)
- Activity and Fragment Transition in Lollipop lets you run a transition when you launch or leave an activity
  - [Content Transitions](https://www.androiddesignpatterns.com/2014/12/activity-fragment-content-transitions-in-depth-part2.html)
  - [Shared Element Transitions](https://www.androiddesignpatterns.com/2015/01/activity-fragment-shared-element-transitions-in-depth-part3a.html)
- Animation timing
  - slow enough to convey meaning but as fast as possible, so they doesn't get in the way.  
	 - About 300ms
  - Use size and distance to determine timing

---
  ## References
  - [Design | Android Developers](https://developer.android.com/design/index.html)
  - [Material Design](https://material.io/design)
