package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.Confidence;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Striker2 extends Job {

    public Striker2() {
        // 기본
        super();
        this.setName("스트라이커(2초, 리레단일)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        this.setAscentDamage(2465646.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (255 + 157 + 72 + 223));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (255 + 157 + 72 + 223));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addOtherStat1(10L);
        passive.addOtherStat2(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
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

        // 2차
        passive = new Common();
        passive.setDescription("너클 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("너클 마스터리");
        passive.addFinalDamage(1.07);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("단련");
        passive.addMainStat(60L);
        passive.addCriticalP(15.0);
        passive.addCriticalDamage(5.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("뇌백");
        passive.addAtt(25L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("극갑");
        passive.addDamage(5L);
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("뇌제");
        passive.addAtt(30L);
        passive.addCriticalDamage(10.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("너클 엑스퍼트");
        passive.addAtt(60L);
        passive.addFinalDamage(1.17);
        passive.addCriticalDamage(15.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("뇌신");
        passive.addCriticalP(10.0);
        passive.addCriticalDamage(15.0);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-60L);
        this.addMainStat(-21L);
        this.addSubStat(5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Confidence());
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
        doping.setDescription("뇌전 5스택");
        doping.addDamage(20L);
        doping.addIgnoreDefenseList(45L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("태풍 버프");
        doping.addDamage(15L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("너클 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(3L);
        doping.addCriticalDamage(1.0);
        doping.minusFinalDamage(1.17);
        doping.addFinalDamage(1.18);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
