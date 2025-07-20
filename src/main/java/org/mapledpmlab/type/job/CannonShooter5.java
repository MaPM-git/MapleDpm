package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.link.PirateBlessing;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class CannonShooter5 extends Job {

    public CannonShooter5() {
        // 기본
        super();
        this.setName("캐논슈터(5초, 리웨)");
        this.setConstant(1.5);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2484300.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (348 + 214 + 72 + 256));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (348 + 214 + 72 + 256));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("빌드업 캐논");
        passive.addAtt(20L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("크리티컬 파이어");
        passive.addCriticalP(20.0);
        passive.addCriticalDamage(5.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("캐논 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("오크통 룰렛");
        passive.addFinalDamage(1.1);
        passive.addCriticalDamage(10.0);
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("리인포스 캐논");
        passive.addFinalDamage(1.05);
        passive.addAtt(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("반격의 슈터");
        passive.addFinalDamage(1.05);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("오버버닝 캐논");
        passive.addFinalDamage(1.31);
        passive.addIgnoreDefenseList(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("하이퍼 몽키 스펠");
        passive.addMainStat(61L);
        passive.addSubStat(61L);
        passive.addOtherStat1(61L);
        passive.addOtherStat2(61L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("파이렛 스피릿");
        passive.addBossDamage(30L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-72L);
        this.addMainStat(9L);
        this.addSubStat(10L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new PirateBlessing());
        this.setUnion(new StrUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());

        this.addObject(getPassiveList());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("몽키 퓨리어스");
        doping.addDamage(40L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("오버버닝 캐논(콜렉터의 영약)");
        doping.minusFinalDamage(1.31);
        doping.addFinalDamage(1.32);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("하이퍼 몽키 스펠(콜렉터의 영약)");
        doping.addMainStat(1L - 30);
        doping.addSubStat(1L - 30);
        doping.addOtherStat1(1L - 30);
        doping.addOtherStat2(1L - 30);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
