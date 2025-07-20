package org.mapledpmlab.type.job;

import org.mapledpmlab.type.etc.Common;

public class ZeroAlpha extends Zero {

    public ZeroAlpha() {
        // 기본
        super();
        this.setName("제로 - 알파(2초, 리레단일)");
        this.setConstant(1.34);         // 무기상수(알파)
        this.setMastery(1.90 / 2);      // 숙련도

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (337 + 151 + 72 + 252));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (337 + 151 + 72 + 252));

        // 알파
        passive = new Common();
        passive.setDescription("태도 마스터리");
        passive.addAtt(40L);
        passive.addFinalDamage(1.23);
        passive.addIgnoreDefenseList(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("리인포스 바디");
        passive.addCriticalP(30.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("디바인 리어");
        passive.addCriticalDamage(50.0);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("아머 스플릿 5중첩");
        doping.addIgnoreDefenseList(50L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("래피드 타임 5중첩");
        doping.addDamage(5L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("인피니트 레조넌스");
        doping.addAtt(50L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
