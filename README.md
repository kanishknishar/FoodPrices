# Food Price Comparison Tool

Java application comparing retail vs online prices for grocery items, calculating savings and discount percentages with proper currency formatting which demonstrates proficiency with regular expression.

## Features

- **Price Comparison**: Retail vs online prices for 35+ grocery items
- **Discount Analysis**: Individual item discounts and percentages
- **Savings Calculator**: Total savings and average discount rate
- **Currency Formatting**: Proper Indian Rupee (₹) display using NumberFormat
- **Data Parsing**: Regex-based text parsing with named capture groups

## Technical Implementation

**Core Technologies:**
- `Pattern/Matcher` for regex-based data extraction
- `NumberFormat` with Indian locale for currency formatting
- Text blocks for embedded data storage
- Named capture groups for structured parsing

**List Structure:**
```
Item Name - Retail Price -- Online Price
```

**Key Components:**
- **Regex Pattern**: `(?<item>.*?)-\s*(?<retailPrice>\d+)\s*--\s*(?<onlinePrice>(\d+|N/A))\s*`
- **Currency Formatter**: `NumberFormat.getCurrencyInstance(Locale.of("English", "IN"))`
- **Percentage Formatter**: `NumberFormat.getPercentInstance()`

## Output

Displays:
- Individual item discounts with rupee amounts and percentages
- Total savings across all comparable items
- Average discount percentage
