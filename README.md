# 📚 Coding Interview Preparation - Complete Learning System

> Master algorithms and data structures through **incremental, organized learning**

## 🎯 What This Is

A comprehensive coding interview preparation system with:
- **170+ markdown documents** (converted from 63 PowerPoint slides)
- **283 practice problems** with complete solutions
- **7-phase learning path** for incremental mastery
- **29,341 lines** of optimized, professional documentation
- **Full-text search** and responsive design

**Not for beginners.** This assumes you can comfortably solve [CodingBat](http://codingbat.com/java) style problems and want to master interview-level algorithms.

---

## 🚀 Quick Start (5 minutes)

### 1. Create Virtual Environment
```bash
python3 -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
```

### 2. Install Dependencies
```bash
pip install -r requirements.txt
```

### 3. Start Documentation Server
```bash
mkdocs serve
```

### 4. Open in Browser
Visit: **http://localhost:8000**

---

## 📦 Requirements

All dependencies are in `requirements.txt`:
- **mkdocs** (1.5.3) - Documentation generator
- **mkdocs-material** (9.4.14) - Professional theme
- **python-markdown-math** (0.8) - Math rendering
- **pymdown-extensions** (10.5) - Extended markdown

### Install Specific Version
```bash
pip install -r requirements.txt
```

---

## 📚 What You'll Learn

### Phase 1: Fundamentals (1 week)
- Big O notation and complexity analysis
- Time/space complexity tradeoffs
- Data structure comparison

### Phase 2: Core Data Structures (2 weeks)
- Arrays & Linked Lists
- Stacks & Queues
- Hash Tables

### Phase 3: Trees (2 weeks)
- Binary Search Trees
- Heaps
- Tries & Ternary Search Trees

### Phase 4: Sorting & Searching (2 weeks)
- 8 sorting algorithms
- String search (Boyer-Moore, Rabin-Karp)
- Complexity analysis

### Phase 5: Advanced Trees (2 weeks)
- AVL Trees
- Red-Black Trees
- Splay Trees
- B-Trees

### Phase 6: Graph Algorithms (2 weeks)
- Graph traversal (BFS/DFS)
- Connected components
- Basic graph theory

### Phase 7: Practice Problems (Ongoing)
- 283 problems from major coding platforms
- Complete solutions in Java
- Interview preparation

**Total:** ~13 weeks to interview-ready mastery

---

## 💾 Project Structure

```
CodingInterviewPreps/
├── README.md                    (This file)
├── requirements.txt             (Python dependencies)
├── mkdocs.yml                   (Documentation config)
├── build.gradle                 (Java build)
├── src/
│   └── main/java/              (329 Java source files)
│       ├── 01-fundamentals/
│       ├── 02-data-structures/
│       ├── 03-algorithms/
│       └── 04-practice/
└── docs/                        (1.1 MB documentation)
    ├── index.md                 (Home page)
    ├── 01-java-algo-datastruct/ (Phase 1-3)
    ├── 02-algorithms-part2/     (Phase 4)
    ├── 03-advanced-graphs/      (Phase 5-6)
    ├── 04-algorithmic-java/     (Phase 7)
    └── 05-practice-problems/    (283 problems)
```

---

## 🔧 Development Setup

### Full Setup (with IDE)

```bash
# Clone or navigate to repo
cd CodingInterviewPreps

# Create virtual environment
python3 -m venv venv
source venv/bin/activate

# Install all dependencies
pip install -r requirements.txt

# Optional: Install Java build tools
# (gradle already configured)

# Start documentation server
mkdocs serve
```

### For Documentation Only
```bash
# If you only want to read documentation
python3 -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
mkdocs serve
```

### For Java Development
```bash
# To run/build Java code
./gradlew build
./gradlew test
```

---

## 📖 Reading the Documentation

### In Browser (Recommended)
```bash
mkdocs serve
# Opens http://localhost:8000
```

Features:
- **Full-text search** (🔍 icon, top-right)
- **Dark/light mode** toggle
- **Mobile responsive** design
- **Syntax highlighting** for code
- **Cross-references** between topics

### Offline (Build Static HTML)
```bash
mkdocs build
# Creates 'site/' directory with static HTML
open site/index.html
```

---

## 🎓 Learning Path

**Start here:** Click "Phase 1 - Fundamentals" in the sidebar

**Progression:**
1. Read overview for each phase
2. Study each topic (5-10 topics per phase)
3. Answer mastery checklist
4. Move to next phase only when confident
5. Practice with 283 interview problems

**Time commitment:**
- 2-3 hours per week per phase
- 13 weeks total to mastery
- Can be done faster or slower based on pace

---

## 📊 Content Overview

| Component | Count | Status |
|-----------|-------|--------|
| Markdown docs | 170 | ✅ Complete |
| Documentation lines | 29,341 | ✅ Optimized |
| Data structure topics | 14 | ✅ Complete |
| Algorithm topics | 56+ | ✅ Complete |
| Practice problems | 283 | ✅ Complete |
| Learning phases | 7 | ✅ Complete |

---

## 🛠️ Commands Reference

### Documentation Commands
```bash
# Start development server
mkdocs serve

# Build static site
mkdocs build

# Clean build artifacts
mkdocs build --clean

# Deploy (GitHub Pages)
mkdocs gh-deploy
```

### Virtual Environment
```bash
# Activate
source venv/bin/activate      # macOS/Linux
venv\Scripts\activate         # Windows

# Deactivate
deactivate

# Update pip
pip install --upgrade pip
```

### Java (Optional)
```bash
# Build
./gradlew build

# Run tests
./gradlew test

# Clean
./gradlew clean
```

---

## 🚀 Deployment Options

### Option 1: GitHub Pages (Free, Auto-deploy)
```bash
# Push to GitHub with GitHub Pages enabled
git push origin main
# Automatically deploys to github.com/username/CodingInterviewPreps
```

### Option 2: Netlify (Free, CI/CD)
1. Connect GitHub repository to Netlify
2. Set build command: `mkdocs build`
3. Set publish directory: `site`
4. Auto-deploys on push

### Option 3: Self-hosted
```bash
mkdocs build
# Upload 'site/' folder to your web server
```

---

## ✨ Features

- ✅ **Full-text search** across all 170 documents
- ✅ **Professional theme** with Material Design
- ✅ **Responsive layout** (desktop, tablet, mobile)
- ✅ **Code syntax highlighting** (Java, pseudocode)
- ✅ **Dark/light mode** support
- ✅ **Navigation breadcrumbs** for easy browsing
- ✅ **Table of contents** on every page
- ✅ **Cross-referenced links** between topics
- ✅ **SEO-friendly** structure

---

## 📝 File Structure Explained

### Documentation (`docs/`)
- **170 markdown files** - All documentation content
- **1.1 MB total** - Optimized, no bloat
- **29,341 lines** - Concise and comprehensive

### Source Code (`src/`)
- **329 Java files** - Implementation examples
- **4 categories** - Organized by complexity
- **Commented code** - Easy to understand

### Configuration
- **mkdocs.yml** - Navigation and theme config
- **requirements.txt** - Python dependencies
- **build.gradle** - Java build configuration

---

## 🎯 Next Steps

1. **[Start Learning]** Run `mkdocs serve` and open http://localhost:8000
2. **[Phase 1]** Read "Phase 1 - Fundamentals" overview
3. **[Study]** Work through each topic in order
4. **[Practice]** Solve 283 interview problems in Phase 7
5. **[Master]** Complete all 7 phases for interview readiness

---

## 📚 Related Resources

- **CodingBat:** http://codingbat.com/java
- **LeetCode:** https://leetcode.com/
- **HackerRank:** https://www.hackerrank.com/
- **AlgoExpert:** https://www.algoexpert.io/

---

## 💡 Tips for Success

1. **Don't skip phases** - Each builds on the previous
2. **Code along** - Implement examples yourself
3. **Use search** - Find specific topics quickly
4. **Master fundamentals** - Don't rush to Phase 7
5. **Time yourself** - Practice interview timing
6. **Review weak areas** - Revisit topics as needed

---

## ✅ You're All Set!

Everything is configured and ready to go.

```bash
source venv/bin/activate
mkdocs serve
```

Then visit: **http://localhost:8000**

**Happy learning!** 🚀

---

*Last updated: April 27, 2026*  
*Status: ✅ Complete and Production-Ready*  
*Content: 170 documents, 29,341 lines, 283 practice problems*
