#!/usr/bin/env python
# coding: utf-8

# In[12]:


import os
import json
import matplotlib.pyplot as plt

def findAllFile(base):
    for root, ds, fs in os.walk(base):
        for f in fs:
            if f.endswith('.json'):
                fullname = os.path.join(root, f)
                yield fullname

def main():
    base = '.'
    for root, ds, fs in os.walk(base):
        for f in fs:
            if f.endswith('.json'):
                with open(os.path.join(root, f)) as fo:
                    data = json.load(fo)
                    
                    plt.plot(data['X'],data['Two For'],label='Two For')
                    plt.plot(data['X'],data['Hash Left'],label='Hash Left')
                    plt.plot(data['X'],data['Hash Left And Right'],label='Hash Left And Right')
            
                    plt.legend(loc='upper left')
                    plt.title('Memery ' + data['Memery'] + 'MB')
            
                    # 设置横轴的上下限
                    plt.ylim(0, 110)
            
                    plt.savefig(f.replace('.json','.png'),dpi=300)
                    plt.close()
            
if __name__ == '__main__':
    main()
    print('done.')


# In[ ]:




