package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Hero3 extends Job {

    public Hero3() {
        // 기본
        super();
        this.setName("히어로(3초, 리레단일)");
        this.setConstant(1.44);         // 무기상수
        this.setMastery(1.9 / 2);       // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION3);

        this.setAscentDamage(2990160.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (340 + 210 + 72 + 253));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("스피릿 블레이드");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("웨폰 마스터리");
        passive.addFinalDamage(1.1);
        passive.addCriticalP(15.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("웨폰 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addAtt(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("찬스 어택");
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("인레이지");
        passive.addCriticalDamage(20.0);
        passive.addFinalDamage(1.25);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 콤보(하이퍼 포함)");
        passive.addFinalDamage(2.3);
        passive.addBossDamage(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("컴뱃 마스터리");
        passive.addIgnoreDefenseList(51L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 파이널 어택");
        passive.addAtt(31L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정, 3초뚝
        //this.addMainStat(8L);

        // 환산 보정, 스탯뚝
        this.addMainStatP(-66L);
        this.addMainStat(4L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new StrUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("어드밴스드 콤보는 딜사이클 클래스에서 따로 관리");
        doping.minusFinalDamage(2.3);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("찬스 어택");
        doping.addFinalDamage(1.25);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("인레이지(콜렉터의 영약)");
        doping.minusFinalDamage(1.25);
        doping.addFinalDamage(1.26);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("컴뱃 마스터리(콜렉터의 영약)");
        doping.addIgnoreDefenseList(51L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드밴스드 파이널 어택(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("스피릿 블레이드(콜렉터의 영약)");
        doping.addAtt(-30L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
