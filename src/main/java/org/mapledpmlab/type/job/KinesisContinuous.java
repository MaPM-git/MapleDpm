package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.PassiveBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperKinesis;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class KinesisContinuous extends Job {

    public KinesisContinuous() {
        // 기본
        super();
        this.setName("키네시스(0초, 컨티)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2081250.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (992));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (992));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(8L);
        passive.addSubStat(8L);
        passive.addMagic(5L);
        //passive.addBossDamage(70L);
        //passive.addMagicP(9L);
        passive.addBossDamage(30L);
        passive.addMagicP(21L);
        passive.addMagicP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("초감각");
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("싸이킥 포스");
        passive.addMagic(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("내재1");
        passive.addMagic(10L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("싸이킥 포스2");
        passive.addMagic(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("순수한 힘");
        passive.addDamage(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("내재2");
        passive.addMagic(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("ESP 마스터리");
        passive.addCriticalP(10.0);
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("싸이킥 포스3");
        passive.addMagic(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("정신강화");
        passive.addMagicP(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("정교");
        passive.addCriticalP(20.0);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("싸이킥 차징");
        passive.addBossDamage(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("싸이코 브레이크");
        passive.addFinalDamage(1.4);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("ESP 배틀 오더");
        passive.addMagic(54L);
        passive.addDamage(22L);
        passive.addFinalDamage(1.22);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("각성");
        passive.addFinalDamage(1.16);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("정신집중-유지");
        passive.addPlusBuffDuration(22L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("전달");
        passive.addIgnoreDefenseList(27L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("숙달");
        passive.addCriticalDamage(12.0);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(27L);
        this.addMainStat(-15L);
        this.addSubStat(10L);

        this.setAbility(new PassiveBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new IntUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperKinesis(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("싸이킥 차징(콜렉터의 영약)");
        doping.addBossDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("ESP 배틀 오더(콜렉터의 영약)");
        doping.addMagic(2L);
        doping.addDamage(1L);
        doping.minusFinalDamage(1.22);
        doping.addFinalDamage(1.23);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("정신집중-유지(콜렉터의 영약)");
        doping.addPlusBuffDuration(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("숙달(콜렉터의 영약)");
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
