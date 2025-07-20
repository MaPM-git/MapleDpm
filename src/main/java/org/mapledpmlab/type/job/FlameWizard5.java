package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.PassiveBossBuff;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class FlameWizard5 extends Job {

    public FlameWizard5() {
        // 기본
        super();
        this.setName("플레임위자드(5초, 리웨)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.98 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2260545.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (406 + 250 + 72 + 276));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat((long) (10 + 80 + 75));
        passive.addSubStat(75L);
        passive.addAtt(45L);
        passive.addMagic((long) (1 + 45));
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
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
        passive.setDescription("북 오브 파이어");
        passive.addMagic(20L);
        passive.addCriticalP(5.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("주문 연마");
        passive.addMagic(10L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("해방된 마력");
        passive.addFinalDamage(1.25);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("약점 분석");
        passive.addCriticalP(30.0);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("번뜩이는 깨달음");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("마법의 진리");
        passive.addMagic(22L);
        passive.addFinalDamage(1.56);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스피릿 오브 플레임");
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("엘리멘트 : 플레임 IV");
        passive.addMagicP(3L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-12L);
        this.addMainStat(-4L);
        this.addSubStat(5L);

        this.setAbility(new PassiveBossBuff());
        //this.setAbility(new PassiveBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new IntUnion());
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
        doping.setDescription("엘리멘트 : 플레임 IV");
        doping.addMagic(42L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("엘리멘트 : 플레임 IV(콜렉터의 영약)");
        doping.addMagic(1L);
        doping.addMagicP(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("마법의 진리(콜렉터의 영약)");
        doping.addMagic(1L);
        doping.minusFinalDamage(1.56);
        doping.addFinalDamage(1.59);
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
