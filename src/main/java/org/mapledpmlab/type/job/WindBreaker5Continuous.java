package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class WindBreaker5Continuous extends Job {

    public WindBreaker5Continuous() {
        // 기본
        super();
        this.setName("윈드브레이커(5초, 컨티)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2462460.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (318 + 196 + 72 + 246));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (318 + 196 + 72 + 246));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addOtherStat1(10L);
        passive.addOtherStat2(10L);
        passive.addAtt(3L);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("엘리멘탈 엑스퍼트");
        passive.addAttP(10L);
        passive.addMagicP(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("엘리멘탈 하모니");
        passive.addMainStat(
                (this.getLevel() - 1) / 2
        );
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("엘리멘트 : 스톰");
        passive.addDamage(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("위스퍼 오브 더 윈드");
        passive.addAtt(20L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("실프스 에이드");
        passive.addAtt(20L);
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("티타늄 화살");
        passive.addAtt(9L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("보우 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("보우 마스터리");
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("알바트로스");
        passive.addAtt(20L);
        passive.addCriticalP(10.0);
        passive.addFinalDamage(1.09);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("샤프 아이즈");
        passive.addCriticalP(21.0 - 10);
        passive.addCriticalDamage(16.0 - 8);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("윈드 블레싱");
        passive.addAttP(11L);
        passive.addMainStatP(16L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("보우 엑스퍼트");
        passive.addAtt(31L);
        passive.addFinalDamage(1.36);
        passive.addCriticalDamage(20.0);
        passive.addBossDamage(41L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("알바트로스 맥시멈");
        passive.addAtt(31L);
        passive.addDamage(25L);
        passive.addIgnoreDefenseList(15L);
        passive.addCriticalP(15.0);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-57L);
        this.addMainStat(-6L);
        this.addSubStat(5L);

        this.setAbility(new BossCriticalAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new DexUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperArcher(this.getLevel()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("세컨드 윈드");
        doping.addAtt(15L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("세이람의 영약");
        doping.addCriticalP(-20.0);
        doping.addCriticalDamage(-16.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("보우 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addCriticalDamage(1.0);
        doping.addBossDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("알바트로스 맥시멈(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
