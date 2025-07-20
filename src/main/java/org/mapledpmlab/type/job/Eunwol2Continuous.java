package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Eunwol2Continuous extends Job {

    public Eunwol2Continuous() {
        // 기본
        super();
        this.setName("은월(2초, 컨티)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.90 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        this.setAscentDamage(2128000.0);

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
        passive.addAtt(3L);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("가호의 증표");
        passive.addAtt(20L);
        passive.addDamage(10L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("호기체현");
        passive.addDamage(10L);
        passive.addCriticalP(15.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("너클 숙련");
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("근력 단련");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("정령 결속 3식");
        passive.addFinalDamage(1.15);
        passive.addBossDamage(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("약화");
        passive.addIgnoreDefenseList(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("일치단결");
        passive.addAtt(20L);
        passive.addDamage(20L);
        passive.addCriticalDamage(10.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("정령 결속 4식");
        passive.addBossDamage(31L);
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("고급 너클 숙련");
        passive.addFinalDamage(1.17);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("약점 간파");
        passive.addCriticalP(11.0);
        passive.addCriticalDamage(20.0);
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-60L);
        this.addMainStat(9L);
        this.addSubStat(0L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new StrUnion());

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
        doping.setDescription("약화");
        doping.addDamage(20L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("정령 결속 4식(콜렉터의 영약)");
        doping.addIgnoreDefenseList(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
