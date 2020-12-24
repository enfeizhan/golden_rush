#!/usr/bin/env python
# coding: utf-8

# In[1]:


from pyspark import SparkContext


# In[4]:


sc = SparkContext('local[3]', 'word count')


# In[5]:


lines = sc.textFile('covid')


# In[9]:


words = lines.flatMap(lambda line: line.lower().split(' '))


# In[13]:


wordCounts = words.countByValue()


# In[11]:


for word, count in wordCounts.items():
    print('{}: {}'.format(word, count))


# In[ ]:




