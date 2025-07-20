package org.mapledpmlab.type.job;

import org.mapledpmlab.type.etc.Common;

public class ZeroBetaContinuous extends ZeroContinuous {

    public ZeroBetaContinuous() {
        // 기본
        super();
        this.setName("제로 - 베타(2초, 컨티)");
        this.setConstant(1.49);         // 무기상수(베타)
        this.setMastery(1.90 / 2);      // 숙련도

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (342 + 151 + 72 + 255));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (342 + 151 + 72 + 255));

        // 베타
        passive = new Common();
        passive.setDescription("대검 마스터리");
        passive.addCriticalP(30.0);
        passive.addDamage(50L);
        passive.addBossDamage(30L);
        passive.addAtt(80L);
        passive.addFinalDamage(1.23);
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
