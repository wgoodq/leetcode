#!/usr/bin/env python
# coding: utf-8

import json
import os
import subprocess

import matplotlib.pyplot as plt


def draw():
    base = './out/'
    for root, ds, fs in os.walk(base):
        for f in fs:
            if f.endswith('.json'):
                with open(os.path.join(root, f)) as fo:
                    data = json.load(fo)
                    if 'X' in data.keys():
                        for key in data.keys():
                            if key not in ['Memery', 'title', 'X']:
                                plt.plot(data['X'], data[key], label=key)
                    else:
                        for key in data.keys():
                            plt.plot(data[key], label=key)
                    plt.legend(loc='upper left')
                    plt.title(data['title'])

                    # 设置横轴的上下限
                    plt.ylim(0, 100)

                    plt.xlabel('Target Count')
                    plt.ylabel('Consume Time(ms)')

                    plt.savefig('out/' + f.replace('.json', '.png'), dpi=300)
                    plt.close()


def main():
    print(subprocess.getoutput('mvn clean package'))

    ss = ('java -Xmx$m -Xms$m -jar /Users/kyou/WorkSpace/Gitee/leetcode/target/leetcode-1.0-jar-with-dependencies.jar '
          '$ -2-')

    for i in range(1, 20):
        # cmd = ss.replace("$", '2450')
        cmd = ss.replace("$", str(i * 50))
        print("cmd: " + cmd)
        print(subprocess.getoutput(cmd))

    draw()


if __name__ == '__main__':
    main()
    print('done.')
